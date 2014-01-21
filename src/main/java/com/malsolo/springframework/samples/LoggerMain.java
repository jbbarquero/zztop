package com.malsolo.springframework.samples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerMain {

	final static Logger logger = LoggerFactory.getLogger(LoggerMain.class);

	public static void main(String[] args) {
		logger.info("Entering application.");

		Foo foo = new Foo();
		foo.doIt();
		logger.info("Exiting application.");		
	}

}
