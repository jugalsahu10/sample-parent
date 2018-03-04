/*
 * Copyright (c)
 */

package com.sample.external;

import com.sample.api.web.model.base.BaseRestResponse;
import com.sample.api.web.model.response.SampleResponse;
import org.springframework.stereotype.Component;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Component
public class SampleFallback implements SampleClient {

  @Override
  public BaseRestResponse<SampleResponse> get(String sample) {
    return new BaseRestResponse("fallback(get)", "fallback(get)", true, null, null);
  }

  @Override
  public BaseRestResponse<SampleResponse> fallback(String sample) {
    return new BaseRestResponse("fallback(fallback)", "fallback(fallback)", true, null, null);
  }
}
