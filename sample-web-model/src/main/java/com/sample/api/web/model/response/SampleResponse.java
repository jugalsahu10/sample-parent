/*
 * Copyright (c)
 */

package com.sample.api.web.model.response;

import com.sample.api.web.model.base.BaseResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleResponse extends BaseResponse {

  String sample;
}
