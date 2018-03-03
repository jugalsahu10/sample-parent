/*
 * Copyright (c)
 */

package com.sample.configuration.cache;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by hendrik.prayogo on 7/18/2017.
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "embedded.cache")
public class EmbeddedTomcatCacheProperties {

  private int size;
  private int timeToLive;

}
