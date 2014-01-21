package com.malsolo.mercurious.scheduled;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.QuartzJobBean;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class PingJob extends QuartzJobBean implements ApplicationContextAware {

	final static Logger logger = LoggerFactory.getLogger(PingJob.class);

	private Ping ping;

	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Override
	protected void executeInternal(JobExecutionContext context)
			throws JobExecutionException {
		String msg = "Iniciando tarea programada de Ping {}";
		logger.info(msg, "BEGIN...");
		ping = this.applicationContext.getBean("ping", Ping.class);
		ping.call();
		logger.info(msg, "BEGIN...");
	}

}
