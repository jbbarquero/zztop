package com.malsolo.springframework.samples;

import java.util.concurrent.TimeUnit;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import com.malsolo.mercurious.scheduled.TesterSchedulers;

@Configuration
//@ImportResource({"classpath:META-INF/spring/applicationContext-quartz-persisted.xml", "classpath:META-INF/spring/properties-config.xml"})
@ImportResource({"classpath:META-INF/spring/applicationContext-quartz-non-persisted.xml", "classpath:META-INF/spring/properties-config.xml"})
public class QuartzMain {
	
	private static final long TIEMPO_ESPERA_POR_QUARTZ = TimeUnit.MINUTES.toMillis(1); //TimeUnit.HOURS.toMillis(1);

	private @Value("${jdbc.url}") String url;
	private @Value("${jdbc.driverClassName}") String driverClassName;
	private @Value("${jdbc.username}") String username;
	private @Value("${jdbc.password}") String password;


	final static Logger logger = LoggerFactory.getLogger(QuartzMain.class);
	
	@Bean
	public DataSource dataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(driverClassName);
		ds.setUrl(url);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setTestOnBorrow(true);
		ds.setTestOnReturn(true);
		ds.setTestWhileIdle(true);
		ds.setTimeBetweenEvictionRunsMillis(1800000);
		ds.setNumTestsPerEvictionRun(3);
		ds.setMinEvictableIdleTimeMillis(1800000);
		return ds;
	}

	@Bean
	public PlatformTransactionManager transactionManager() {
		DataSourceTransactionManager tm = new DataSourceTransactionManager();
		tm.setDataSource(dataSource());
		return tm;
	}

	public static void main(String... args) {
		logger.info(">>>>> MAIN <<<<< ");
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		logger.info("····· ctx ");
		ctx.register(QuartzMain.class);
		logger.info("····· Main ");
		ctx.scan(QuartzMain.class.getPackage().toString());
		logger.info("····· Scan ");
		ctx.refresh();
		logger.info("····· Refresh ");
		QuartzMain main = ctx.getBean(QuartzMain.class);
		main.testSchedulers(ctx.getBean(TesterSchedulers.class));
		main.doSomeStuff();
		ctx.close();
		logger.info(">>>>> MAIN END <<<<< ");
	}

	public void doSomeStuff() {
		String msg = "STUFFING {}";
		logger.info(msg, "...");
		
		try {
			logger.warn("A esperar {} ms ", TIEMPO_ESPERA_POR_QUARTZ);
			Thread.sleep(TIEMPO_ESPERA_POR_QUARTZ);
			logger.info("Woke up after {} ms ", TIEMPO_ESPERA_POR_QUARTZ);
		} catch (InterruptedException e) {
			logger.error("Interrupted: {} ", e.getMessage());
			Thread.currentThread().interrupt();
		}
		logger.info(msg, ". DONE.");
	}
	
	public void testSchedulers(final TesterSchedulers tester) {
		Thread t  = new Thread( new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(TimeUnit.SECONDS.toMillis(10));
					tester.test();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}, "TESTER-THREAD");
		t.start();
	}
	
}
