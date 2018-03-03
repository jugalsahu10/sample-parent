/*
 * Copyright (c)
 */

package com.sample.configuration.web.interceptor;

import lombok.AllArgsConstructor;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@AllArgsConstructor
public class MandatoryParameterInterceptor extends HandlerInterceptorAdapter {

  private Tracer tracer;

  @Override
  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
      throws Exception {
    return super.preHandle(request, response, handler);
  }
}
