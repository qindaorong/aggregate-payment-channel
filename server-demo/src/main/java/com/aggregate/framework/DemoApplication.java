package com.aggregate.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationPid;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;


@Slf4j
@ImportResource(locations= {"classpath:spring/yiji-openapi-sdk.xml"})
@SpringBootApplication
public class DemoApplication  {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(DemoApplication.class)
				.main(DemoApplication.class)
				.run(args);
		log.info("----DemoApplication Start PID={}----", new ApplicationPid().toString());
		context.registerShutdownHook();
	}
}