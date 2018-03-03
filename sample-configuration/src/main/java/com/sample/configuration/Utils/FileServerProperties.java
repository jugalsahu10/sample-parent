/*
 * Copyright (c)
 */

package com.sample.configuration.Utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Configuration
@ConfigurationProperties(prefix = "sample.file.server")
@Data
public class FileServerProperties {

  private String host;
  private Integer port;
  private String username;
  private String password;
  private String context;
}
