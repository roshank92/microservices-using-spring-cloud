package com.rk.micro.currencyconversionservice;

import com.rk.micro.currencyconversionservice.bean.CurrencyConversionBean;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")//  ribbon not  configured
//@FeignClient(name = "currency-exchange-service") // once ribbon configured
@FeignClient(name = "netflix-zuul-api-server-gateway") // once ribbon configured
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyExchangeServiceProxy {

    @GetMapping("/currency-exchange-service/currency-exchange/from/{from}/to/{to}")
    CurrencyConversionBean retrieveExchangeValue(@PathVariable("from") String from,
                                                        @PathVariable("to") String to);


}
