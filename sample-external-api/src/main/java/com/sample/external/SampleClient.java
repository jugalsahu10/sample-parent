/*
 * Copyright (c)
 */

package com.sample.external;

import com.sample.api.web.model.base.BaseRestResponse;
import com.sample.api.web.model.response.SampleResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@FeignClient(name = "demo", url = "http://localhost:8080/sample", fallback = SampleFallback.class)
public interface SampleClient {

  @GetMapping(value = "/get")
  BaseRestResponse<SampleResponse> get(@RequestParam("sample") String sample);

  @GetMapping(value = "/fallback")
  BaseRestResponse<SampleResponse> fallback(@RequestParam("sample") String sample);
}
