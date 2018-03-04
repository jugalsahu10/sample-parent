/*
 * Copyright (c)
 */

package com.sample.configuration.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ReadPreference;
import com.mongodb.WriteConcern;
import com.sample.configuration.Utils.MessageProperties;
import com.sample.configuration.cache.EmbeddedTomcatCacheProperties;
import com.sample.configuration.db.mongo.MongoProperties;
import org.apache.catalina.Context;
import org.apache.catalina.webresources.StandardRoot;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.net.UnknownHostException;

/**
 * Created by jugalkishorsahu on Feb, 2018
 */
@Configuration
@ComponentScans({@ComponentScan(basePackages = "com.sample.repository"),
    @ComponentScan(basePackages = "com.sample.service"),
    @ComponentScan(basePackages = "com.sample.configuration"),
    @ComponentScan(basePackages = "com.sample.outbound")})
@EnableMongoRepositories(value = "com.sample.repository")
@EnableMongoAuditing(auditorAwareRef = "stringAuditorAware")
public class ServiceConfiguration {

  private String DESCRIPTION = "mongodb";

  @Autowired
  private EmbeddedTomcatCacheProperties embeddedTomcatCacheProperties;

  @Autowired
  private MessageProperties messageProperties;

  @Autowired
  private Tracer tracer;

  @Bean
  public MongoClient createMongo(
      org.springframework.boot.autoconfigure.mongo.MongoProperties mongoProperties,
      Environment environment, MongoProperties sampleMongoProperties) throws UnknownHostException {

    MongoClientOptions options =
        new MongoClientOptions.Builder().writeConcern(WriteConcern.ACKNOWLEDGED)
            .connectionsPerHost(sampleMongoProperties.getConnectionPerHost())
            .minConnectionsPerHost(sampleMongoProperties.getMinConnectionsPerHost())
            .threadsAllowedToBlockForConnectionMultiplier(
                sampleMongoProperties.getThreadsAllowedToBlockForConnectionMultiplier())
            .connectTimeout(sampleMongoProperties.getConnectTimeout())
            .maxWaitTime(sampleMongoProperties.getMaxWaitTime())
            .socketKeepAlive(sampleMongoProperties.getSocketKeepAlive())
            .socketTimeout(sampleMongoProperties.getSocketTimeout())
            .heartbeatConnectTimeout(sampleMongoProperties.getHeartbeatConnectTimeout())
            .heartbeatFrequency(sampleMongoProperties.getHeartbeatFrequency())
            .heartbeatSocketTimeout(sampleMongoProperties.getHeartbeatSocketTimeout())
            .maxConnectionIdleTime(sampleMongoProperties.getMaxConnectionIdleTime())
            .maxConnectionLifeTime(sampleMongoProperties.getMaxConnectionLifeTime())
            .minHeartbeatFrequency(sampleMongoProperties.getMinHeartbeatFrequency())
            .readPreference(ReadPreference.primary()).description(this.DESCRIPTION).build();

    MongoClient mongoClient = mongoProperties.createMongoClient(options, environment);

    return mongoClient;
  }

  @Bean
  public static DeserializationProblemHandlerImpl deserializationProblemHandler() {
    return new DeserializationProblemHandlerImpl();
  }

  @Bean
  public ObjectMapper createObjectMapper() throws Exception {
    ObjectMapper objectMapper = new ObjectMapper();
    objectMapper.configure(DeserializationFeature.FAIL_ON_NUMBERS_FOR_ENUMS, true);
    objectMapper.configure(DeserializationFeature.READ_ENUMS_USING_TO_STRING, true);
    objectMapper.configure(SerializationFeature.WRITE_ENUMS_USING_TO_STRING, true);
    objectMapper.configure(DeserializationFeature.ACCEPT_FLOAT_AS_INT, false);
    objectMapper.addHandler(ServiceConfiguration.deserializationProblemHandler());
    return objectMapper;
  }

  @Bean
  public EmbeddedServletContainerFactory servletContainer() {
    TomcatEmbeddedServletContainerFactory tomcatFactory =
        new TomcatEmbeddedServletContainerFactory() {
          @Override
          protected void postProcessContext(Context context) {
            StandardRoot standardRoot = new StandardRoot(context);
            standardRoot.setCacheMaxSize(embeddedTomcatCacheProperties.getSize());
            standardRoot.setCacheTtl(embeddedTomcatCacheProperties.getTimeToLive());
            context.setResources(standardRoot);

            logger.info(
                String.format("New cache size (KB): %d", context.getResources().getCacheMaxSize()));
          }
        };
    return tomcatFactory;
  }

  @Bean
  public Mapper createDozerMapper() {
    return new DozerBeanMapper();
  }

  @Bean
  public AuditorAware<String> stringAuditorAware() {
    return new AuditorAware<String>() {
      @Override
      public String getCurrentAuditor() {
        return "system";
      }
    };
  }
}
