package com.malsolo.springframework.samples;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class TimeMain {
	
	public static void main(String... args) {
		
		//long instant = 1390384274000;
		long instant = 1390384274000l;//Next: 1390384320000. 22/01/2014 10:52:00. Start: 1390384274000. 22/01/2014 10:51:14
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		System.err.println(fmt.print(instant));
		
	}

}
