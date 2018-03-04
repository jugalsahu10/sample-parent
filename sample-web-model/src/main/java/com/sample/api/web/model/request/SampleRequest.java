/*
 * Copyright (c)
 */

package com.sample.api.web.model.request;

import com.sample.api.web.model.base.BaseRequest;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SampleRequest extends BaseRequest {

  String sample;
}
