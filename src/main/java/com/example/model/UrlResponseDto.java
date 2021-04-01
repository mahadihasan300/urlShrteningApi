package com.example.model;
/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */


//Will give response to the user the original link and shortLink

public class UrlResponseDto {
	
	private long id;
	private String originalUrl;
	private String shortUrlDomain;
	private String shortLink;
	
	
	public UrlResponseDto() {
		
	}

	public UrlResponseDto(long id, String originalUrl, String shortUrlDomain, String shortLink) {
		this.id = id;
		this.originalUrl = originalUrl;
		this.shortUrlDomain = shortUrlDomain;
		this.shortLink = shortLink;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getShortLink() {
		return shortLink;
	}

	public void setShortLink(String shortLink) {
		this.shortLink = shortLink;
	}

	public String getShortUrlDomain() {
		return shortUrlDomain;
	}

	public void setShortUrlDomain(String shortUrlDomain) {
		this.shortUrlDomain = shortUrlDomain;
	}

	@Override
	public String toString() {
		return "UrlResponseDto [originalUrl=" + originalUrl + ", shortLink=" + shortLink + "]";
	}
	
	

}
