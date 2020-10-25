package com.gavinkim.demo.common;

import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

  public static String generate() {
    return String.format("%s-%s-%s", RandomStringUtils.randomAlphabetic(6),
        RandomStringUtils.randomNumeric(6),
        RandomStringUtils.randomAlphanumeric(6)).toUpperCase();
  }

  public static String randomCode(){
    return String.format("%s",RandomStringUtils.randomAlphanumeric(6)).toUpperCase();
  }
}
