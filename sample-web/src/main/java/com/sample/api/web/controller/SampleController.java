/*
 * Copyright (c)
 */

package com.sample.api.web.controller;

import com.sample.api.SampleService;
import com.sample.api.web.helper.api.ConverterService;
import com.sample.api.web.model.base.BaseRestResponse;
import com.sample.api.web.model.response.SampleResponse;
import com.sample.external.SampleClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Slf4j
@RestController
public class SampleController {

  @Autowired
  private SampleService sampleService;

  @Autowired
  private ConverterService converterService;

  @Autowired
  private SampleClient sampleClient;

  @RequestMapping(value = {"/get"}, method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE})
  public BaseRestResponse<SampleResponse> get(@RequestParam String sample) throws Exception {
    log.debug("get sample: {}", sample);

    return new BaseRestResponse(true,
        converterService.convert(sampleService.sampleService(sample), SampleResponse.class), null);
  }

  @RequestMapping(value = {"/fallback"}, method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE})
  public BaseRestResponse<SampleResponse> fallback(@RequestParam String sample) throws Exception {
    log.debug("get sample: {}", sample);

    Thread.sleep(2000);
    return new BaseRestResponse(true,
        converterService.convert(sampleService.sampleService(sample), SampleResponse.class), null);
  }

  @RequestMapping(value = {"/get/feign"}, method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE})
  public BaseRestResponse<SampleResponse> getFeign(@RequestParam String sample) throws Exception {
    log.debug("get sample: {}", sample);

    return sampleClient.get(sample);
  }

  @RequestMapping(value = {"/fallback/feign"}, method = RequestMethod.GET, produces = {
      MediaType.APPLICATION_JSON_VALUE})
  public BaseRestResponse<SampleResponse> getFallback(@RequestParam String sample)
      throws Exception {
    log.debug("get sample: {}", sample);

    return sampleClient.fallback(sample);
  }
}
