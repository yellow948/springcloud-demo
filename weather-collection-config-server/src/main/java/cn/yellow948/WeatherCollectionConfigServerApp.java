package cn.yellow948;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;


@EnableAutoConfiguration
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class WeatherCollectionConfigServerApp {
    public static void main(String[] args) {
        SpringApplication.run(WeatherCollectionConfigServerApp.class, args);
    }
}
