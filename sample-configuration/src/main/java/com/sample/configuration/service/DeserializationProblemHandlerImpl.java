/*
 * Copyright (c)
 */

package com.sample.configuration.service;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.deser.DeserializationProblemHandler;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Slf4j
public class DeserializationProblemHandlerImpl extends DeserializationProblemHandler {

  @Override
  public boolean handleUnknownProperty(DeserializationContext ctxt, JsonParser jp,
      JsonDeserializer<?> deserializer, Object beanOrClass, String propertyName)
      throws IOException {
    log.warn("unknown field : {}", propertyName);
    return true;
  }
}
