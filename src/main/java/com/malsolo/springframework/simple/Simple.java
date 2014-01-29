package com.malsolo.springframework.simple;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Simple {
	
	private @Value("${jdbc.url}") String jdbcUrl;
	private @Value("${jdbc.mobile:false}") boolean mobile = true;

	public String getJdbcUrl() {
		return jdbcUrl;
	}

	public boolean isMobile() {
		return mobile;
	}
	
}
