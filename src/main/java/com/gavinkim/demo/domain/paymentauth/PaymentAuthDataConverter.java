package com.gavinkim.demo.domain.paymentauth;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentAuthDataConverter implements AttributeConverter<PaymentAuthData, String> {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public String convertToDatabaseColumn(PaymentAuthData authData) {
    try {
      return objectMapper.writeValueAsString(authData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public PaymentAuthData convertToEntityAttribute(String s) {
    try {
      return objectMapper.readValue(s,PaymentAuthData.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }
}
