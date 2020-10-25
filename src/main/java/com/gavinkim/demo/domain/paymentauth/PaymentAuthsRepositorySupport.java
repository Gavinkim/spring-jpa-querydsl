package com.gavinkim.demo.domain.paymentauth;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class PaymentAuthsRepositorySupport extends QuerydslRepositorySupport {

  private final JPAQueryFactory queryFactory;

  public PaymentAuthsRepositorySupport(JPAQueryFactory queryFactory) {
    super(PaymentAuths.class);
    this.queryFactory = queryFactory;
  }

  public List<PaymentAuths> findByUserId(String userId){
    QPaymentAuths paymentAuths = QPaymentAuths.paymentAuths;
    return queryFactory.selectFrom(paymentAuths)
        .where(paymentAuths.paymentAuthsId.auths.userId.eq(userId))
        .fetch();
  }

}
