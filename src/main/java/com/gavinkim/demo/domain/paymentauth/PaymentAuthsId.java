package com.gavinkim.demo.domain.paymentauth;

import com.gavinkim.demo.domain.auths.Auths;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode
public class PaymentAuthsId implements Serializable {

  private static final long serialVersionUID = 1L;

  @MapsId("userId")
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "userId")
  private Auths auths;

  @Column(name = "paymentAuthType", nullable = false, updatable = false)
  private int paymentAuthType;

  @Builder
  public PaymentAuthsId(Auths auths, int paymentAuthType) {
    this.auths = auths;
    this.paymentAuthType = paymentAuthType;
  }
}
