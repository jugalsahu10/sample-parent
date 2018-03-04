/*
 * Copyright (c)
 */

package com.sample.api.web.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BaseRestResponse<T> implements Serializable {

  private static final long serialVersionUID = -2202435222425148959L;

  private String errorMessage;
  private String errorCode;
  private boolean success;
  private T data;
  private Paging paging;

  public BaseRestResponse(boolean success) {
    this.success = success;
  }

  public BaseRestResponse(boolean success, T data) {
    this.success = success;
    this.data = data;
  }

  public BaseRestResponse(boolean success, T data, Paging paging) {
    this.success = success;
    this.data = data;
    this.paging = paging;
  }
}
