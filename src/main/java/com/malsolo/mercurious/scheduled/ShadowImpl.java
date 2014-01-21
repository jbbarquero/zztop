package com.malsolo.mercurious.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ShadowImpl implements Shadow {
	
	final static Logger logger = LoggerFactory.getLogger(ShadowImpl.class);

	@Override
	public int doStuff() {
		String msg = "***** SHADOW->Do stuff {}";
		logger.info(msg, "BEGIN...");
		System.err.println(msg);
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		int i = 0;
		logger.info(msg, "END.");
		return i;
	}

}
