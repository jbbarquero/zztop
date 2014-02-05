package com.malsolo.java8;

import java.util.concurrent.TimeUnit;

public class IntStreamMain {
	
	public final static long TIME_PER_TASK = TimeUnit.SECONDS.toMillis(1);
	
	public static void main(String... args) {
		System.out.printf("Available processors: %d \n", Runtime.getRuntime().availableProcessors());
		IntStreamMain program = new IntStreamMain();
		program.legacy();
		program.fancy();
		program.parallel();
	}
	
	public void legacy() {
		System.out.println("\nLegacy...");
		long start = System.nanoTime();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(TIME_PER_TASK);
			}
			catch (InterruptedException ex) {
				ex.printStackTrace();
			}
			System.out.printf("%d, ", i);
		}
		long end = System.nanoTime();
		System.out.printf("\nLegacy. Done. It took %d s ", TimeUnit.NANOSECONDS.toSeconds(end-start));
	}
	
	public void fancy() {
		System.out.println("\nFancy...");
		long start = System.nanoTime();
		/*
		IntStream.range(0, 10).forEach(
			nbr -> {
				try {
					Thread.sleep(TIME_PER_TASK);
				}
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.out.printf("%d, ", nbr);
			}
		);
		*/
		long end = System.nanoTime();
		System.out.printf("\nFancy. Done. It took %d s ", TimeUnit.NANOSECONDS.toSeconds(end-start));
	}

	public void parallel() {
		System.out.println("\nParallel...");
		long start = System.nanoTime();
		/*
		IntStream.range(0, 10).parallel().forEach(
			nbr -> {
				try {
					Thread.sleep(TIME_PER_TASK);
				}
				catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.out.printf("%d, ", nbr);
			}
		);
		*/
		long end = System.nanoTime();
		System.out.printf("\nParallel. Done. It took %d s ", TimeUnit.NANOSECONDS.toSeconds(end-start));
	}
}
