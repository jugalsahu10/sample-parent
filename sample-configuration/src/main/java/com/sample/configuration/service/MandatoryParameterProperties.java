/*
 * Copyright (c)
 */

package com.sample.configuration.service;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "mandatory.param")
public class MandatoryParameterProperties {

  private String storeId;
  private String username;
}
