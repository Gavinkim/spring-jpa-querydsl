package com.gavinkim.demo.domain;

import com.gavinkim.demo.common.Utils;
import com.gavinkim.demo.domain.auths.AuthData;
import com.gavinkim.demo.domain.auths.Auths;
import com.gavinkim.demo.domain.auths.AuthsRepository;
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
class AuthsRepositoryTest {

  @Autowired
  private AuthsRepository authsRepository;


  @Test
  @DisplayName(value = "사용자 인증 데이터 저장 테스트")
  public void authsSaveTest(){
    AuthData authData = AuthData.builder()
        .device(Utils.randomCode())
        .build();
    Auths auths = Auths.builder()
        .authStatus(1)
        .changed(LocalDateTime.now())
        .userId(Utils.generate())
        .authData(authData)
        .build();
    authsRepository.save(auths);
  }
}