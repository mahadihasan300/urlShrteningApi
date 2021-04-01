package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

@Entity
public class ClickedInformation {
	
	@Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
	private String Id;
	private String userDevice;
	private String userIp;
	private String userBrowser;
	private String clickedShortLink;
	
	public ClickedInformation() {
		
	}

	public ClickedInformation(String id, String userDevice, String userIp, String userBrowser,
			String clickedShortLink) {
		super();
		Id = id;
		this.userDevice = userDevice;
		this.userIp = userIp;
		this.userBrowser = userBrowser;
		this.clickedShortLink = clickedShortLink;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getUserDevice() {
		return userDevice;
	}

	public void setUserDevice(String userDevice) {
		this.userDevice = userDevice;
	}

	public String getUserIp() {
		return userIp;
	}

	public void setUserIp(String userIp) {
		this.userIp = userIp;
	}

	public String getUserBrowser() {
		return userBrowser;
	}

	public void setUserBrowser(String userBrowser) {
		this.userBrowser = userBrowser;
	}

	public String getClickedShortLink() {
		return clickedShortLink;
	}

	public void setClickedShortLink(String clickedShortLink) {
		this.clickedShortLink = clickedShortLink;
	}
	
	

}
