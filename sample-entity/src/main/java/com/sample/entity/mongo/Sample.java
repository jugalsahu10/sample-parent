/*
 * Copyright (c)
 */

package com.sample.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * Created by jugalkishorsahu on Mar, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "sample")
public class Sample extends BaseEntity {

  @Field(value = "sample")
  private String sample;
}
