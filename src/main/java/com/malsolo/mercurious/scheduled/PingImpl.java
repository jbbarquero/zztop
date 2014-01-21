package com.malsolo.mercurious.scheduled;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PingImpl implements Ping {
	
	final static Logger logger = LoggerFactory.getLogger(PingImpl.class);

	Random random = new Random();

	@Override
	public void call() {
		String msg = "***** PING->call {}";
		System.err.println(msg);
		logger.info(msg, "BEGIN...");
		int max = random.nextInt(10);
		for (int i = 0; i < max; i++) {
			logger.info(msg, i);
		}
		logger.info(msg, "END.");
	}

}
