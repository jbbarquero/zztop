package com.malsolo.mercurious.scheduled.listeners;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

public class MalTriggerListener implements TriggerListener {

	@Override
	public String getName() {
		return this.getClass().getSimpleName();
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.err.println("=== TRIGGER FIRED:" + trigger.toString() + " in context: "+ context.toString());

	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		System.err.println("=== TRIGGER MISSFIRED:" + trigger.toString());
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			int triggerInstructionCode) {
		System.err.println("=== TRIGGER COMPLETE:" + trigger.toString() + " in context: "+ context.toString() + " with code: " + triggerInstructionCode);
	}

}
