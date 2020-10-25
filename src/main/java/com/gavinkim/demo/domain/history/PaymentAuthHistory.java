package com.gavinkim.demo.domain.history;

import com.gavinkim.demo.domain.paymentauth.PaymentAuths;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "PaymentAuthHistories")
public class PaymentAuthHistory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long paymentAuthHistoryId;


  @ManyToOne
  @JoinColumns(value = {
      @JoinColumn(name = "userId"),
      @JoinColumn(name = "paymentAuthType")
  })
  private PaymentAuths paymentAuths;

  @Column(name = "PaymentAuthHistoryStatus")
  private int paymentAuthHistoryStatus;

  @Column(name = "PaymentAuthHistoryData",length = 1024)
  @Convert(converter = PaymentAuthHistoryDataConverter.class)
  private PaymentAuthHistoryData paymentAuthHistoryData;

  @Column(name = "Registered")
  private LocalDateTime registered;

  @Builder
  public PaymentAuthHistory(Long paymentAuthHistoryId,
      PaymentAuths paymentAuths, int paymentAuthHistoryStatus,
      PaymentAuthHistoryData paymentAuthHistoryData) {
    this.paymentAuthHistoryId = paymentAuthHistoryId;
    this.paymentAuths = paymentAuths;
    this.paymentAuthHistoryStatus = paymentAuthHistoryStatus;
    this.paymentAuthHistoryData = paymentAuthHistoryData;
  }

  @PrePersist
  void preRegistered() {
    this.registered = LocalDateTime.now();
  }
}
