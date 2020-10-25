package com.gavinkim.demo.domain.paymentauth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PaymentAuthData {
  private String device;
  private double la;
  private double lo;
}
