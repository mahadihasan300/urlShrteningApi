package com.example.service;


import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.model.Url;
import com.example.model.UrlDto;
import com.example.repository.UrlRepository;
/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */


@Component
public class UrlServiceImpl implements UrlService {
	
	@Autowired
	private UrlRepository urlRepository;

	@Override
	public Url generateShortLink(UrlDto urlDto) {
		
		if(StringUtils.isNotEmpty(urlDto.getUrl())) {
			
			String encodedUrl = encodedUrl(urlDto.getUrl() , urlDto.getShortUrlDomain());
			String shortDomain = urlDto.getShortUrlDomain();
			Url urlToPersist = new Url();
			urlToPersist.setOriginalUrl(urlDto.getUrl());
			urlToPersist.setShortLink(encodedUrl);
			urlToPersist.setShortUrlDomain(shortDomain);
			
			Url urlToRet = persistShortLink(urlToPersist);
			
			if(urlToRet != null) 
				return urlToRet;
			
			return null;
			
		}
		
		return null;
	}

	//Generate a short link
	private String encodedUrl(String url, String shortUrl) {
		String rand = RandomStringUtils.randomAlphanumeric(6);
		String encodedUrl = "";
		//encodedUrl = shortUrl.concat(rand);
		encodedUrl = rand;
	    
		return  encodedUrl;
		
	}

	//Saving into DB
	@Override
	public Url persistShortLink(Url url) {
		
		Url urlToRet = urlRepository.save(url);
		
		return urlToRet;
	}
	
	
	// Finding short link based on user input
	@Override
	public Url getEncodedUrl(String url) {
		Url urlToRet = urlRepository.findByShortLink(url);
		return urlToRet;
	}

}
