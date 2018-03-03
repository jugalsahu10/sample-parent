/*
 * Copyright (c)
 */

package com.sample.configuration.cache;

import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Configuration
@EnableCaching
public class CacheConfiguration extends CachingConfigurerSupport {

  @Bean
  @Override
  public CacheErrorHandler errorHandler() {
    return new CacheErrorHandlerImpl();
  }
}
