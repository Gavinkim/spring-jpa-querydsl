package com.gavinkim.demo.domain.history;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentAuthHistoryRepository extends JpaRepository<PaymentAuthHistory,Long> {

}
