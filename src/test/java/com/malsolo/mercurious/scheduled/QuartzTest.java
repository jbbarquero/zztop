package com.malsolo.mercurious.scheduled;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations = {
				"classpath:META-INF/spring/applicationContext.xml",
				"classpath:META-INF/spring/applicationContext-quartz.xml" 
				}
)
public class QuartzTest {
	
	final static Logger logger = LoggerFactory.getLogger(QuartzTest.class);

	@Before
	public void before() {
		logger.info("##### BEFORE TEST #####");
	}
	
	@After
	public void after() {
		logger.info("##### AFTER TEST #####");
	}
	
	@Test
	public void testJob() throws InterruptedException {
		String msg = "TESTING {}";
		logger.info(msg, "...");
		Thread.sleep(15000);
		logger.info(msg, ". DONE.");
	}
	

}
