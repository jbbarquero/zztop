package com.malsolo.springframework.samples;

import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.List;

public class RuntimeMain {
	
	public static void main(String... args) {
		System.out.println("Let's see the Runtime parameters...");
		new RuntimeMain().runtimeParameters();
		System.out.println("Runtime parameters. DONE.");
	}

	public void runtimeParameters() {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
		List<String> aList = bean.getInputArguments();

		for (int i = 0; i < aList.size(); i++) {
			System.out.println( aList.get( i ) );
		}
	}

}
