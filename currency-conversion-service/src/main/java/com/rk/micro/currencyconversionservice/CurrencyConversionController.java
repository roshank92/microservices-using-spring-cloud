package com.rk.micro.currencyconversionservice;

import com.rk.micro.currencyconversionservice.bean.CurrencyConversionBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyConversionController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private Environment environment;

    @Autowired
    private CurrencyExchangeServiceProxy currencyExchangeServiceProxy;

    @GetMapping("/currency-converter/from/{from}/to/{to}/{quantity}")
    public CurrencyConversionBean convertCurrency(@PathVariable("from") String from,
                                                  @PathVariable("to") String to,
                                                  @PathVariable("quantity") BigDecimal quantity

                                                  ){
        logger.info("Request to get conversion");
        CurrencyConversionBean response = currencyExchangeServiceProxy.retrieveExchangeValue(from,to);
        CurrencyConversionBean currencyConversionBean =  new CurrencyConversionBean(1001l,response.getFrom(),response.getTo(), response.getConversionMultiple(),quantity,BigDecimal.ONE);
        currencyConversionBean.setPort(response.getPort());

        return currencyConversionBean;
    }
}
