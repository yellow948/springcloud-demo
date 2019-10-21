package cn.yellow948;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
public class WeatherCollectionApp {
    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionApp.class, args);
    }
}
