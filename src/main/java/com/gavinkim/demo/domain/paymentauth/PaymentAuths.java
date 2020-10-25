package com.gavinkim.demo.domain.paymentauth;


import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "PaymentAuths")
public class PaymentAuths {

  @EmbeddedId
  private PaymentAuthsId paymentAuthsId;

  @Column(name = "PaymentAuthData",length = 1024)
  @Convert(converter = PaymentAuthDataConverter.class)
  private PaymentAuthData paymentAuthData;

  @Column(name = "Priority")
  private int priority;

  @Column(name = "PaymentAuthStatus")
  private int paymentAuthStatus;

  @Column(name = "Changed")
  private LocalDateTime changed;

  @Column(name = "Registered")
  private LocalDateTime registered;

  @Builder
  public PaymentAuths(PaymentAuthsId paymentAuthsId,
      PaymentAuthData paymentAuthData, int priority, int paymentAuthStatus,
      LocalDateTime changed) {
    this.paymentAuthsId = paymentAuthsId;
    this.paymentAuthData = paymentAuthData;
    this.priority = priority;
    this.paymentAuthStatus = paymentAuthStatus;
    this.changed = changed;
  }

  @PrePersist
  void preRegistered() {
    this.registered = LocalDateTime.now();
  }


//  @PreUpdate
//  void preUpdateChanged(){
//    this.changed = LocalDateTime.now();
//  }

}
