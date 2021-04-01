package com.example.model;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */


//For user input , user will give original Url

public class UrlDto {
	
	private String url;
	private String shortUrlDomain;
	private Parameters parameters;

	public UrlDto() {
	
	}

	public UrlDto(String url, String shortUrlDomain, Parameters parameters) {
		this.url = url;
		this.shortUrlDomain = shortUrlDomain;
		this.parameters = parameters;
	}

	public String getShortUrlDomain() {
		return shortUrlDomain;
	}

	public void setShortUrlDomain(String shortUrlDomain) {
		this.shortUrlDomain = shortUrlDomain;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	

	public Parameters getParameters() {
		return parameters;
	}

	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}


	
	
	

}
