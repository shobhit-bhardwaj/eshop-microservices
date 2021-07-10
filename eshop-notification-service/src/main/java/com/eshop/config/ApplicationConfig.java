package com.eshop.config;

import java.util.function.Consumer;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationConfig {
	private static final Logger logger = LogManager.getLogger(ApplicationConfig.class);

	@Bean
	public Consumer<KStream<String, String>> notificationService() {
		return kStream -> kStream.foreach((key, message) -> {
			logger.info("notificationService Cloud Function - {}", message);

			System.out.println(message);
		});
	}
}