package com.programacion4.ejercicio10.config;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

public class DotenvEnvironmentPostProcessor implements EnvironmentPostProcessor, Ordered {

	private static final String[] KEYS = { "DB_URL", "DB_USER", "DB_PASS" };

	@Override
	public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
		Dotenv dotenv = Dotenv.configure()
				.ignoreIfMissing()
				.load();

		for (String key : KEYS) {
			if (environment.getProperty(key) == null && dotenv.get(key) != null) {
				System.setProperty(key, dotenv.get(key));
			}
		}
	}

	@Override
	public int getOrder() {
		return Ordered.HIGHEST_PRECEDENCE;
	}
}
