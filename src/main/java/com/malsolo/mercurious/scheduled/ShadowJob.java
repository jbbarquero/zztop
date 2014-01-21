package com.malsolo.mercurious.scheduled;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class ShadowJob extends QuartzJobBean {

	final static Logger logger = LoggerFactory.getLogger(ShadowJob.class);

	private Shadow shadow;

	public void setShadow(Shadow shadow) {
		this.shadow = shadow;
	}

	@Override
	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		String msg = "Haciendo sombra con Shadow {} {}";
		logger.info(msg, "...", "...", "...");
		int i = shadow.doStuff();
		logger.info(msg, "HECHO", "Obtenidos", i);
	}

}
