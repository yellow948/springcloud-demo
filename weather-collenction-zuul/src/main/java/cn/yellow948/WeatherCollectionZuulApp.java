package cn.yellow948;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;


@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableZuulProxy
public class WeatherCollectionZuulApp {
    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionZuulApp.class, args);
    }
}
