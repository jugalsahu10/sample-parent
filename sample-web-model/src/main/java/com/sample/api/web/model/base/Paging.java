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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Paging implements Serializable{

  private Integer page;
  private Integer totalPage;
  private Integer itemPerPage;
  private Long totalItem;

}
