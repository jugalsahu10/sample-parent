/*
 * Copyright (c)
 */

package com.sample.api.web.helper.api;

import java.util.List;

/**
 * Created by jugalkishorsahu on Jan, 2018
 */
public interface ConverterService {

  <M, T> T convert(M entity, Class<T> clasz) throws Exception;

  <M, T> List<T> convert(List<M> entities, Class<T> clasz) throws Exception;
}
