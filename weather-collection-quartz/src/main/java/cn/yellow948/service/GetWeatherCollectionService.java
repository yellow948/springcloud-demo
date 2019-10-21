package cn.yellow948.service;


import cn.yellow948.dto.CommonResp;
import cn.yellow948.entity.Weather;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("weather-collection")
public interface GetWeatherCollectionService {

    // 调用xxx服务的某个controller
    @GetMapping("/weather-service/getWeatherToughGet")
    CommonResp refresh (@RequestParam("city") String city);

    @PostMapping("/weather-service/getWeatherToughPost")
    CommonResp refreshPost (Weather weather);

}
