package com.example.rest.webservice.config;

import java.util.Locale;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Configuration
public class SpringConfigClass {

	@Bean
	public LocaleResolver getLocaleresolver() {
		AcceptHeaderLocaleResolver  localeResolver = new AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
	}

	
	/*
	 * @Bean public ResourceBundleMessageSource messageSource() {
	 * ResourceBundleMessageSource bundleMessageSource = new
	 * ResourceBundleMessageSource(); bundleMessageSource.setBasename("message");
	 * return bundleMessageSource; }
	 */
}
