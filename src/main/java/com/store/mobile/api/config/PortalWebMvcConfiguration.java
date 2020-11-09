package com.store.mobile.api.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.store.mobile.api.interceptor.ValidatorInterceptor;

/**
 *Mohammad Miyan
 */
@Configuration
@EnableWebMvc
public class PortalWebMvcConfiguration implements WebMvcConfigurer {
	@Autowired
	private ValidatorInterceptor validatorInterceptor;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry //
		.addInterceptor(validatorInterceptor) ;
	}

	
}
