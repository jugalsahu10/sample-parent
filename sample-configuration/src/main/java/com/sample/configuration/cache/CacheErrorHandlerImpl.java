/*
 * Copyright (c)
 */

package com.sample.configuration.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.Cache;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.stereotype.Service;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Service
public class CacheErrorHandlerImpl implements CacheErrorHandler {

  private static final Logger LOGGER = LoggerFactory.getLogger(CacheErrorHandlerImpl.class);

  @Override
  public void handleCacheClearError(RuntimeException exception, Cache cache) {
    LOGGER.error("CacheClearError, message : {}", exception.getMessage(), exception);
  }

  @Override
  public void handleCacheEvictError(RuntimeException exception, Cache cache, Object key) {
    LOGGER.error("CacheEvictError, message : {}", exception.getMessage(), exception);
  }

  @Override
  public void handleCacheGetError(RuntimeException exception, Cache cache, Object key) {
    LOGGER.error("CacheGetError, message : {}", exception.getMessage(), exception);
  }

  @Override
  public void handleCachePutError(RuntimeException exception, Cache cache, Object key,
      Object value) {
    LOGGER.error("CachePutError, message : {}", exception.getMessage(), exception);
  }
}
