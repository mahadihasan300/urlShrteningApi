package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.Url;
import com.example.model.UrlDto;
/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

@Service
public interface UrlService {
	
	public Url generateShortLink(UrlDto urlDto);
	public Url persistShortLink(Url url);
	public Url getEncodedUrl(String url);

}
