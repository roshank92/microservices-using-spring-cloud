package com.rk.micro.limitservice;

import com.rk.micro.limitservice.bean.LimitConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitsConfigurationController {

    @Autowired
    private Configurations configurations;

    @GetMapping("/limits")
    public LimitConfiguration retrieveLimitConfig(){
        return new LimitConfiguration(configurations.getMin(),configurations.getMax());
    }

}
