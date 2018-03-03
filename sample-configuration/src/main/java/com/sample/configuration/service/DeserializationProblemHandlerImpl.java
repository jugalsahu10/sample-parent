/*
 * Copyright (c)
 */

package com.sample.configuration.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
public class DeserializationProblemHandlerImpl
    extends com.fasterxml.jackson.databind.deser.DeserializationProblemHandler {
  private static final Logger LOG = LoggerFactory.getLogger(DeserializationProblemHandlerImpl.class);

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp,
      JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName)
      throws IOException {
    DeserializationProblemHandlerImpl.LOG.warn("unknown field : {}", propertyName);
    return true;
  }
}
