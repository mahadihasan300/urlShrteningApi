package com.example.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author : Md. Mahadi Hasan Rabbi
 * @since : 30/03/2021
 */

public interface RequestService {
	String getClientIp(HttpServletRequest request);

}
