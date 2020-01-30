package com.rk.micro.currencyexchangeservice;

import com.rk.micro.currencyexchangeservice.beans.ExchangeValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExchangeValueRepository extends JpaRepository<ExchangeValue,Long> {
    ExchangeValue findAllByFromAndTo(String from ,String to);
}
