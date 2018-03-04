/*
 * Copyright (c)
 */

package com.sample.repository.api;

import com.sample.entity.mongo.Sample;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
public interface SampleRepository extends MongoRepository<Sample, String> {

  Sample findBySample(String sample);
}
