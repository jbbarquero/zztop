package com.malsolo.mercurious.scheduled.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

public class MalJobListener implements JobListener {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		System.err.println("--- JOB TO BE EXECUTED:" + context.toString());
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		System.err.println("--- JOB EXECUTION VETOED:" + context.toString());
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context,
			JobExecutionException jobException) {
		System.err.println("--- JOB WAS EXECUTED:" + context.toString());
	}

}
