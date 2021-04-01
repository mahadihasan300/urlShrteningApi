package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */



//For the database porpous

@Entity
public class Url {
	
	@Id
    @GeneratedValue
    private long id;
	private String shortUrlDomain;
    @Lob
    private String originalUrl;
    private String shortLink;

    @OneToOne
    private Parameters parameters;
    
	public Url() {

	}

	public Url(long id, String shortUrlDomain, String originalUrl, String shortLink, Parameters parameters) {
		this.id = id;
		this.shortUrlDomain = shortUrlDomain;
		this.originalUrl = originalUrl;
		this.shortLink = shortLink;
		this.parameters = parameters;
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

	public Parameters getParameters() {
		return parameters;
	}


	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}

	public String getShortUrlDomain() {
		return shortUrlDomain;
	}

	public void setShortUrlDomain(String shortUrlDomain) {
		this.shortUrlDomain = shortUrlDomain;
	}

	@Override
	public String toString() {
		return "Url [id=" + id + ", shortUrlDomain=" + shortUrlDomain + ", originalUrl=" + originalUrl + ", shortLink="
				+ shortLink + ", parameters=" + parameters + "]";
	}
  

}
