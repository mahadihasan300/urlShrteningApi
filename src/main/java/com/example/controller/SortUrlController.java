package com.example.controller;

import com.example.model.ClickedInformation;
import com.example.model.Url;
import com.example.model.UrlDto;
import com.example.model.UrlErrorResponseDto;
import com.example.model.UrlResponseDto;
import com.example.repository.ClickedInformationRepository;
import com.example.repository.UrlRepository;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mobile.device.Device;
import org.springframework.web.bind.annotation.*;

import com.example.service.RequestService;
import com.example.service.UrlService;

import eu.bitwalker.useragentutils.Browser;
import eu.bitwalker.useragentutils.UserAgent;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

@RestController
public class SortUrlController {

	@Autowired
	private UrlService urlService;

	@Autowired
	private UrlRepository urlRepository;

	@Autowired
	private RequestService requestService;

	@Autowired
	private ClickedInformationRepository clickedInformationRepository;

	@PostMapping("/generate")
	public ResponseEntity<?> generateShortLink(@RequestBody UrlDto urlDto) {
		Url urlToRet = urlService.generateShortLink(urlDto);

		if (urlToRet != null) {
			UrlResponseDto urlResponseDto = new UrlResponseDto();
		   urlResponseDto.setOriginalUrl(urlToRet.getOriginalUrl());
		   urlResponseDto.setShortUrlDomain(urlToRet.getShortUrlDomain());
			urlResponseDto.setShortLink(urlToRet.getShortLink());
			urlResponseDto.setId(urlToRet.getId());
			return new ResponseEntity<UrlResponseDto>(urlResponseDto, HttpStatus.OK);
		}

		UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
		urlErrorResponseDto.setStatus("404");
		urlErrorResponseDto.setError("Ther was an error");
		return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);

	}

	@GetMapping("/{shortLink}")
	public ResponseEntity<?> redirectToOriginalUrl(@PathVariable String shortLink, HttpServletResponse response,
			HttpServletRequest request, Device device, ClickedInformation clickedInformation) throws IOException {
		if (StringUtils.isEmpty(shortLink)) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Invalid Url");
			urlErrorResponseDto.setStatus("400");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
		}

		Url urlToRet = urlService.getEncodedUrl(shortLink);

		if (urlToRet == null) {
			UrlErrorResponseDto urlErrorResponseDto = new UrlErrorResponseDto();
			urlErrorResponseDto.setError("Url Does not Exist");
			urlErrorResponseDto.setStatus("400");
			return new ResponseEntity<UrlErrorResponseDto>(urlErrorResponseDto, HttpStatus.OK);
		}

		response.sendRedirect(urlToRet.getOriginalUrl());

		clickedInformation.setUserIp(requestService.getClientIp(request));

		// Finding User IP
		System.out.print(requestService.getClientIp(request));

		// Finding User Device
		if (device.isMobile()) {
			clickedInformation.setUserDevice("Mobile");
		} else if (device.isTablet()) {
			clickedInformation.setUserDevice("Tablet");

		} else if (device.isNormal()) {
			clickedInformation.setUserDevice("Browser");
		}

		// Finding User Browser
		UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
		Browser browser = userAgent.getBrowser();

		String browserName = browser.getName();
		
		// Version browserVersion = userAgent.getBrowserVersion();
		
		clickedInformation.setUserBrowser(browserName);
		clickedInformation.setClickedShortLink(shortLink);

		clickedInformationRepository.save(clickedInformation);

		return null;
	}

	//FInding all clicked shortLink data with user information
	@GetMapping("/allClickedData")
	public List<ClickedInformation> getAllClickedData() {
		return clickedInformationRepository.findAll();

	}

	//Finding total Short link
	@GetMapping("/totalShortUrl")
	public String getTotalShortUrl() {
		return urlRepository.findTotalShortUrl();
	}
	
	@GetMapping("/findBy{id}")
	public Optional<Url> getRecordById(@PathVariable Long id) {
		return urlRepository.findById(id);
	}

}
