package cn.yellow948.controller;


import cn.yellow948.dto.CommonResp;
import cn.yellow948.service.GetWeatherCollectionService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TestController {

    @Autowired
    private GetWeatherCollectionService getWeatherCollectionService;


    @GetMapping("/test")
    @HystrixCommand(fallbackMethod = "defaultResponse")
    public CommonResp test (String city) {
        return getWeatherCollectionService.refresh(city);
    }

    // 熔断调用默认返回
    public CommonResp defaultResponse (String city) {
        return new CommonResp(505, "server error");
    }
}
