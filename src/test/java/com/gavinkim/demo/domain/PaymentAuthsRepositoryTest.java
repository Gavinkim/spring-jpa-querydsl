package com.gavinkim.demo.domain;

import com.gavinkim.demo.common.Utils;
import com.gavinkim.demo.domain.auths.AuthData;
import com.gavinkim.demo.domain.auths.Auths;
import com.gavinkim.demo.domain.auths.AuthsRepository;
import com.gavinkim.demo.domain.paymentauth.PaymentAuthData;
import com.gavinkim.demo.domain.paymentauth.PaymentAuths;
import com.gavinkim.demo.domain.paymentauth.PaymentAuthsId;
import com.gavinkim.demo.domain.paymentauth.PaymentAuthsRepository;
import java.time.LocalDateTime;
import javax.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@Rollback
@Transactional
@SpringBootTest
class PaymentAuthsRepositoryTest {

  @Autowired
  private PaymentAuthsRepository paymentAuthsRepository;

  @Autowired
  private AuthsRepository authsRepository;


  @Test
  @DisplayName("인증수단 저장 테스트")
  public void savePaymentAuths(){

    AuthData authData = AuthData.builder()
        .device(Utils.randomCode())
        .build();
    Auths auths = Auths.builder()
        .authStatus(1)
        .changed(LocalDateTime.now())
        .userId(Utils.generate())
        .authData(authData)
        .build();
    Auths savedAuths = authsRepository.save(auths);

    PaymentAuthData paymentAuthData = PaymentAuthData.builder()
        .device(Utils.generate())
        .la(12.000)
        .lo(32.999)
        .build();
    PaymentAuthsId paymentAuthsId = PaymentAuthsId.builder()
        .auths(savedAuths)
        .paymentAuthType(1)
        .build();
    PaymentAuths paymentAuths = PaymentAuths.builder()
        .paymentAuthStatus(1)
        .changed(LocalDateTime.now())
        .paymentAuthData(paymentAuthData)
        .paymentAuthsId(paymentAuthsId)
        .priority(1)
        .build();
    paymentAuthsRepository.save(paymentAuths);
  }

}