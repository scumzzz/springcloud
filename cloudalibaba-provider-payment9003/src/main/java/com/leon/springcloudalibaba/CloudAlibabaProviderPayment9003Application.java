package com.leon.springcloudalibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudAlibabaProviderPayment9003Application {
    public static void main(String[] args) {

        SpringApplication.run(CloudAlibabaProviderPayment9003Application.class, args);

    }
}
