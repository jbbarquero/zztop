package com.malsolo.springframework.samples;

import java.util.Date;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

public class JodaTimeMain {
	
	public static void main(String... args) {
		DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		DateTime dt = new DateTime();
		DateTime end = dt.plusHours(24);
		System.out.printf("From %1$s to %2$s", fmt.print(dt), fmt.print(end));
	}
	
	public Date later() {
		return new DateTime().plusHours(24).toDate();
	}

}
