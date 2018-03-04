/*
 * Copyright (c)
 */

package com.sample.api.web.helper.Impl;

import com.sample.api.web.helper.api.ConverterService;
import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jugalkishorsahu on Jan, 2018
 */
@Service
public class ConverterServiceImpl implements ConverterService {

  @Autowired
  private Mapper mapper;

  @Override
  public <M, T> T convert(M entity, Class<T> clasz) throws MappingException {
    T response = this.mapper.map(entity, clasz);
    return response;
  }

  @Override
  public <M, T> List<T> convert(List<M> entities, Class<T> clasz) throws Exception {
    List<T> responseList = new ArrayList<T>();
    for (M entity : entities) {
      T response = this.mapper.map(entity, clasz);
      responseList.add(response);
    }
    return responseList;
  }
}
