/*
 * Copyright (c)
 */

package com.sample.impl;

import com.sample.repository.api.SampleRepository;
import com.sample.api.SampleService;
import com.sample.entity.mongo.Sample;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Slf4j
@Service
public class SampleServiceImpl implements SampleService {

  @Autowired
  private SampleRepository sampleRepository;

  @Override
  public Sample sampleService(String sample) {
    log.debug("sampleService, sample: {}", sample);
    sampleRepository.deleteAll();
    sampleRepository.save(new Sample(sample));
    return sampleRepository.findBySample(sample);
  }
}
