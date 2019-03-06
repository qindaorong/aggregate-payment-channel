package com.aggregate.framework;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationPid;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;


@Slf4j
@SpringBootApplication
public class DemoApplication extends SpringBootServletInitializer {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = new SpringApplicationBuilder()
				.sources(DemoApplication.class)
				.main(DemoApplication.class)
				.run(args);
		log.info("----DemoApplication Start PID={}----", new ApplicationPid().toString());
		context.registerShutdownHook();
	}

	@Override
	protected SpringApplicationBuilder configure(
			SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}
}