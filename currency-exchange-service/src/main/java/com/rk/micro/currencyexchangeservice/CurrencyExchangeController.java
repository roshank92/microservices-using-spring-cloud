package com.rk.micro.currencyexchangeservice;


import com.rk.micro.currencyexchangeservice.beans.ExchangeValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeValueRepository exchangeValueRepository;

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from,
                                               @PathVariable("to") String to){
        /*ExchangeValue value = new ExchangeValue(1000l,from,to, BigDecimal.valueOf(65));
        value.setPort(Integer.parseInt(environment.getProperty("local.server.port")));*/
        logger.info("Request to get exchange");
        ExchangeValue exchangeValue =  exchangeValueRepository.findAllByFromAndTo(from,to);
        exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeValue;
    }
}
