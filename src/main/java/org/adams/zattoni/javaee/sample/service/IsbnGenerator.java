package org.adams.zattoni.javaee.sample.service;

import java.util.Random;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class IsbnGenerator {

  private Logger logger = Logger.getLogger(IsbnGenerator.class.getName());

  @PostConstruct
  private void init() {
    logger.info("=> IsbnGenerator PostConstruct");
    logger.info("================");
  }

  @PreDestroy
  private void release() {
    logger.info("================");
    logger.info("=> IsbnGenerator PreDestroy");
  }

  public String generateNumber() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}