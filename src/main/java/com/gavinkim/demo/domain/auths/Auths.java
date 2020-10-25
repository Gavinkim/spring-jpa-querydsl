package com.gavinkim.demo.domain.auths;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "Auths")
public class Auths {

  @Id
  @Column(name = "userId",length = 20)
  private String userId;

  @Column(name = "AuthData",length = 1024)
  @Convert(converter = AuthDataConverter.class)
  private AuthData authData;

  @Column(name = "AuthStatus")
  private int authStatus;

  @Column(name = "Changed")
  private LocalDateTime changed;

  @Column(name = "Registered")
  private LocalDateTime registered;

  @Builder
  public Auths(String userId, AuthData authData, int authStatus, LocalDateTime changed) {
    this.userId = userId;
    this.authData = authData;
    this.authStatus = authStatus;
    this.changed = changed;
  }

  @PrePersist
  void preRegistered(){
    this.registered = LocalDateTime.now();
  }
}
