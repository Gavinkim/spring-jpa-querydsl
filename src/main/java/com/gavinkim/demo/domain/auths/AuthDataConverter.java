package com.gavinkim.demo.domain.auths;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class AuthDataConverter implements AttributeConverter<AuthData, String> {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public String convertToDatabaseColumn(AuthData authData) {
    try {
      return objectMapper.writeValueAsString(authData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public AuthData convertToEntityAttribute(String s) {
    try {
      return objectMapper.readValue(s,AuthData.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }
}
