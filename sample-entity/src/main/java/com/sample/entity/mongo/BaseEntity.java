/*
 * Copyright (c)
 */

package com.sample.entity.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseEntity implements Serializable {

  @Id
  @Field(value = "_id")
  private String id;

  @Version
  @Field(value = "version")
  private Long version;

  @CreatedDate
  @Field(value = "created_date")
  private Date createdDate;

  @CreatedBy
  @Field(value = "created_by")
  private String createdBy;

  @LastModifiedDate
  @Field(value = "updated_date")
  private Date updatedDate;

  @LastModifiedBy
  @Field(value = "updated_by")
  private String updatedBy;
}
