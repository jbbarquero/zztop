package com.malsolo.mercurious.scheduled.listeners;

import org.quartz.JobDetail;
import org.quartz.SchedulerException;
import org.quartz.SchedulerListener;
import org.quartz.Trigger;

public class MalSchedulerListener implements SchedulerListener {

	@Override
	public void jobScheduled(Trigger trigger) {
		System.err.println("*** JOB SCHEDULED:" + trigger.toString());
	}

	@Override
	public void jobUnscheduled(String triggerName, String triggerGroup) {
		System.err.println("*** JOB UNSCHEDULED:" + triggerName + " from group: " + triggerGroup);
	}

	@Override
	public void triggerFinalized(Trigger trigger) {
		System.err.println("*** TRIGGER FINALIZED:" + trigger.toString());
	}

	@Override
	public void triggersPaused(String triggerName, String triggerGroup) {
		System.err.println("*** TRIGGERS PAUSED:" + triggerName + " from group: " + triggerGroup);
	}

	@Override
	public void triggersResumed(String triggerName, String triggerGroup) {
		System.err.println("*** TRIGGERS RESUMED:" + triggerName + " from group: " + triggerGroup);
	}

	@Override
	public void jobAdded(JobDetail jobDetail) {
		System.err.println("*** JOB ADDED:" + jobDetail.toString());
	}

	@Override
	public void jobDeleted(String jobName, String groupName) {
		System.err.println("*** JOB DELETED:" + jobName + " from group: " + groupName);
	}

	@Override
	public void jobsPaused(String jobName, String jobGroup) {
		System.err.println("*** JOBS PAUSED:" + jobName + " from group: " + jobGroup);
	}

	@Override
	public void jobsResumed(String jobName, String jobGroup) {
		System.err.println("*** JOBS RESUMED:" + jobName + " from group: " + jobGroup);
	}

	@Override
	public void schedulerError(String msg, SchedulerException cause) {
		System.err.println("*** SCHEDULE ERROR:" + msg + " due to: " + cause.getMessage());
	}

	@Override
	public void schedulerInStandbyMode() {
		System.err.println("*** SCHEDULE STAND BY");
	}

	@Override
	public void schedulerStarted() {
		System.err.println("*** SCHEDULER STARTED");
	}

	@Override
	public void schedulerShutdown() {
		System.err.println("*** SCHEDULER SHUTDOWN");
	}

	@Override
	public void schedulerShuttingdown() {
		System.err.println("*** SCHEDULER SHUTTING DOWN");
	}

}
