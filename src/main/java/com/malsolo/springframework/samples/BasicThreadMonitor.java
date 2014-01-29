package com.malsolo.springframework.samples;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;

public class BasicThreadMonitor implements Runnable {

	@Override
	public void run() {
		
		System.out.println("***** BASIC THREAD MONITOR *****");
		
		ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
		
		System.out.println("Current thread count :" + threadMXBean.getThreadCount());
		System.out.println("CurrentThreadCpuTime :" + threadMXBean.getCurrentThreadCpuTime());
		System.out.println("CurrentThreadUserTime:" + threadMXBean.getCurrentThreadUserTime());
		System.out.println("DaemonThreadCount    :" + threadMXBean.getDaemonThreadCount());
		System.out.println("PeakThreadCount      :" + threadMXBean.getPeakThreadCount());
		System.out.println("ThreadCount          :" + threadMXBean.getThreadCount());

		System.out.println("***** END BASIC THREAD MONITOR *****");
	}

}
