package com.example.spring_cloud_consul_hystrix_turbine_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

@SpringBootApplication
@EnableHystrixDashboard
@EnableTurbine
@EnableDiscoveryClient
public class SpringCloudConsulHystrixTurbineDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConsulHystrixTurbineDemoApplication.class, args);
    }

}
