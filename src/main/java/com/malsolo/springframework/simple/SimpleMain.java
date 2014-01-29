package com.malsolo.springframework.simple;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SimpleMain {
	
	public static void main(String... args) {
		
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/spring/applicationContext-simple.xml");
		Simple simple = ctx.getBean(Simple.class);
		
		System.out.println(simple.getJdbcUrl());
		System.err.println(simple.isMobile());
		
		ctx.close();
		
	}

}
