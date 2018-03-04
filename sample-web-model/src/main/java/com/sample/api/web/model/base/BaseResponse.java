/*
 * Copyright (c)
 */

package com.sample.api.web.model.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseResponse implements Serializable {

  private static final long serialVersionUID = -255944134096567061L;

  private String id;
  private Date createdDate;
  private String createdBy;
  private Date updatedDate;
  private String updatedBy;
  private Long version;
}
