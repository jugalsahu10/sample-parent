/*
 * Copyright (c)
 */

package com.sample.configuration.Utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Jan, 2018
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sample.message")
public class MessageProperties {

  private String host;
  private Integer port;
  private String username;
  private String password;
  private String queueName;
  private String exchangeName;
  private String storeId;
  private String clientId;
  private String channelId;
}
