package com.formaciondbi.springboot.app.item;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
    @Bean("clientRestTemplate")
    @LoadBalanced
    public RestTemplate registryRestTemplate(){
        return new RestTemplate();
    }
}
