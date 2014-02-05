package com.malsolo.mercurious.scheduled;

import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

public class TesterSchedulers {
	
	final static Logger logger = LoggerFactory.getLogger(TesterSchedulers.class);

	@Autowired
	SchedulerFactoryBean schedulerFactoryBean;

	public void test() throws Exception {

		logger.info("Testing schedulers...");

		synchronized (this) {

			StringBuilder status = new StringBuilder();
			String message = "the trigger %s for the job %s in the group %s has state %d ";
			String messageError = "Scheduler error: " + message;
			Scheduler scheduler = schedulerFactoryBean.getScheduler();
			for (String group : scheduler.getJobGroupNames()) {
				for (String jobNameInGroup : scheduler.getJobNames(group)) {
					for (Trigger trigger : scheduler.getTriggersOfJob(jobNameInGroup, group)) {
						int triggerState  = 
								scheduler.getTriggerState(trigger.getName(), trigger.getGroup());

						logger.debug(String.format(message, 
								trigger.getName(), trigger.getJobName(), trigger.getJobGroup(), triggerState));
						
						switch (triggerState) {
						case Trigger.STATE_NONE:
						case Trigger.STATE_COMPLETE:
						case Trigger.STATE_ERROR:
						case Trigger.STATE_BLOCKED:
							String warning = String.format(messageError, 
									trigger.getName(), trigger.getJobName(), trigger.getJobGroup(), triggerState);
							logger.warn(warning);
							status.append(warning);
							break;
						default:
							break;
						}
					}
				}	
			}
			
			if (status.length() != 0) {
				throw new Exception(status.toString());
			}
			
		}
		
		logger.info("Testing schedulers. Done.");
	}
}
