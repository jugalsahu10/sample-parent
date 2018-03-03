/*
 * Copyright (c)
 */

package com.sample.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@EnableHystrix
@ComponentScan(basePackages = {"com.sample"})
@SpringBootApplication
@EnableFeignClients({"com.sample.outbound.api.feign"})
public class SampleWebApp extends SpringBootServletInitializer {

  public static void main(String[] args) {
    SpringApplication.run(SampleWebApp.class, args);
  }

  @Override
  protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
    return application.sources(SampleWebApp.class);
  }

}
