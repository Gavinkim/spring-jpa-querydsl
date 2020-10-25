package com.gavinkim.demo.domain.history;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.AttributeConverter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PaymentAuthHistoryDataConverter implements AttributeConverter<PaymentAuthHistoryData, String> {
  private final ObjectMapper objectMapper = new ObjectMapper();
  @Override
  public String convertToDatabaseColumn(PaymentAuthHistoryData authData) {
    try {
      return objectMapper.writeValueAsString(authData);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }

  @Override
  public PaymentAuthHistoryData convertToEntityAttribute(String s) {
    try {
      return objectMapper.readValue(s,PaymentAuthHistoryData.class);
    } catch (JsonProcessingException e) {
      e.printStackTrace();
      log.error("{}",e.getMessage());
      throw new IllegalArgumentException(e);
    }
  }
}
