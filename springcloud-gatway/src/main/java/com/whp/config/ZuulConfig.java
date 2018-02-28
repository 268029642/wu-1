package com.whp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ZuulConfig {

	@Bean
	public ZuulSecurityFilter zuulSecurityFilter() {
		return new ZuulSecurityFilter();
	}
}
