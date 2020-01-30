package com.rk.micro.netflixzuulapiservergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class NetflixZuulApiServerGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetflixZuulApiServerGatewayApplication.class, args);
	}



}
