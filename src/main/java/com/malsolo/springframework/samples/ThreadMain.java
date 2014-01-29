package com.malsolo.springframework.samples;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadMain {

	private static final long WAITING_TIME = TimeUnit.SECONDS.toMillis(10);
	private static final long KILLERS_AMOUNT = 2;

	final static Logger logger = LoggerFactory.getLogger(ThreadMain.class);

	public static void main(String... args) {

		logger.info(">>>>> MAIN ");
		
		Runtime.getRuntime().addShutdownHook(new Thread(new BasicThreadMonitor()));

		ThreadMain main = new ThreadMain();
		Thread bill = Thread.currentThread();
		for (int i = 0; i < KILLERS_AMOUNT; i++) {
			main.kill(bill, i);
		}
		main.doSomeStuff();
		if (Thread.currentThread().isInterrupted()) {
			logger.error("Why the thread named {} has been interrupted?", Thread.currentThread().getName());
		}

		logger.info("<<<<< MAIN END ");

	}

	public void doSomeStuff() {
		String msg = "STUFFING {}";
		logger.info(msg, "...");

		try {
			logger.info("A esperar {} ms ", WAITING_TIME);
			Thread.sleep(WAITING_TIME);
			logger.info("Woke up after {} ms ", WAITING_TIME);
		} catch (InterruptedException e) {
			logger.error("Interrupted: {} ", e.getMessage());
			Thread.currentThread().interrupt();
		}
		logger.info(msg, ". DONE.");
	}

	public void kill(final Thread bill, final int i) {
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {

				try {
					long timeToKill = WAITING_TIME / 2;
					logger.info("Wait {} ms to kill", timeToKill);
					Thread.sleep(timeToKill);
					logger.info("Killing time! After {}, we will have revenge", timeToKill);
				} catch (InterruptedException e) {
					logger.error("Interrupted: {} ", e.getMessage());
					Thread.currentThread().interrupt();
				}
				logger.warn("Let's kill Bill ");
				logger.debug(bill.isAlive() ? "Bill is still alive " : "Interrupting a thread that is not alive need not have any effect.");
				logger.debug(bill.isInterrupted() ? "Bill has been interrupted " : "Bill hasn't been interrupted yet ");
				bill.interrupt();
				logger.warn("Tu quoque fili ");

			}
		}, "KILLER-"+i);

		t.start();

	}

}
