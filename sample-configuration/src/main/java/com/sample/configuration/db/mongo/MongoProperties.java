/*
 * Copyright (c)
 */

package com.sample.configuration.db.mongo;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "sample.mongo")
public class MongoProperties {

  private Integer connectionPerHost;
  private Integer minConnectionsPerHost;
  private Integer threadsAllowedToBlockForConnectionMultiplier;
  private Integer connectTimeout;
  private Integer maxWaitTime;
  private Integer socketTimeout;
  private Boolean socketKeepAlive;
  private Integer heartbeatConnectTimeout;
  private Integer heartbeatFrequency;
  private Integer heartbeatSocketTimeout;
  private Integer maxConnectionIdleTime;
  private Integer maxConnectionLifeTime;
  private Integer minHeartbeatFrequency;
  private String readPreference;
  private Integer writeNumber;

}
