/*
 * Copyright (c)
 */

package com.sample.entity.mongo.changelog;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.sample.entity.mongo.Sample;
import org.springframework.data.mongodb.core.MongoTemplate;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@ChangeLog
public class MongoChangeLog {

  private static final String STORE_ID = "10001";
  private static final String SYSTEM = "system";

  @ChangeSet(order = "001", id = "createCollections", author = "jugal")
  public void _001_createCollections(MongoTemplate mongoTemplate) {
    if (!mongoTemplate.collectionExists("sample"))
      mongoTemplate.createCollection(Sample.class);
  }
}
