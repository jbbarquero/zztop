package com.malsolo.springframework.samples;

import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

public class PasswordEncoderMain {
	
	public static void main(String... args) {
		ShaPasswordEncoder encoder = new ShaPasswordEncoder(256);
		String encoded = encoder.encodePassword("12345678", null);
		System.out.println(encoded);
	}

}
