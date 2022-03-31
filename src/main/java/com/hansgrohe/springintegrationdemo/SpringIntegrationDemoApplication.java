package com.hansgrohe.springintegrationdemo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
@ImportResource("classpath:demo-int-config.xml")
public class SpringIntegrationDemoApplication {

	private static Log logger = LogFactory.getLog(SpringIntegrationDemoApplication.class);

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/demo-int-config.xml", SpringIntegrationDemoApplication.class);
		SpringApplication.run(SpringIntegrationDemoApplication.class, args);
	}
}
