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
 * Created by jugalkishorsahu on Jan, 2018
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseRequest implements Serializable {

  private static final long serialVersionUID = 115987772448053798L;

  private String id;
  private Date createdDate;
  private String createdBy;
  private Date updatedDate;
  private String updatedBy;
  private Long version;
}
