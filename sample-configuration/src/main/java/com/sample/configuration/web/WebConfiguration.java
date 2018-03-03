/*
 * Copyright (c)
 */

package com.sample.configuration.web;

import com.sample.configuration.web.interceptor.MandatoryParameterInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Configuration
public class WebConfiguration extends WebMvcConfigurerAdapter {

  @Autowired
  private Tracer tracer;

  @Override
  public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
    configurer.enable();
  }

  @Bean
  public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
    return new PropertySourcesPlaceholderConfigurer();
  }

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addRedirectViewController("/docs/v2/api-docs", "/v2/api-docs");
    registry.addRedirectViewController("/docs/feign/ui", "/feign/ui");
    registry.addRedirectViewController("/docs/feign/security", "/feign/security");
    registry.addRedirectViewController("/docs/swagger-resources", "/swagger-resources");
    registry.addRedirectViewController("/docs/swagger-resources/configuration/ui",
        "/swagger-resources/configuration/ui");
    registry.addRedirectViewController("/docs/swagger-resources/configuration/security",
        "/swagger-resources/configuration/security");
    registry.addRedirectViewController("/docs", "/docs/swagger-ui.html");

  }

  @Override
  public void addResourceHandlers(ResourceHandlerRegistry registry) {
    registry.addResourceHandler("/docs/**").addResourceLocations("classpath:/META-INF/resources/");
  }

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MandatoryParameterInterceptor(tracer))
        .excludePathPatterns("/version", "/docs");
  }
}
