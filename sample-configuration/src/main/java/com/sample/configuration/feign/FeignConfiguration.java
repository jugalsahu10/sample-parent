/*
 * Copyright (c)
 */

package com.sample.configuration.feign;

import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Configuration
@EnableFeignClients(basePackages = "com.sample.external")
@EnableCircuitBreaker
public class FeignConfiguration {
}
