/*
 * Copyright (c)
 */

package com.sample.configuration.mongobee;

import com.github.mongobee.Mongobee;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Configuration
public class MongoBeeConfiguration {

  @Bean
  public Mongobee mongobee(MongoProperties mongoProperties) throws Exception {

    Mongobee runner = new Mongobee(mongoProperties.getUri());
    runner.setDbName(mongoProperties.getDatabase());
    runner.setEnabled(true);
    runner.setChangeLogsScanPackage("com.sample.entity.mongo.changelog");

    return runner;
  }
}
