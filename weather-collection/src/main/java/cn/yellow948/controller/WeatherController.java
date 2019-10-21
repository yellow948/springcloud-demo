package cn.yellow948.controller;


import cn.yellow948.dto.CommonResp;
import cn.yellow948.entity.Weather;
import cn.yellow948.service.WeatherServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/weather-service")
public class WeatherController {

    @Autowired
    private WeatherServiceImpl weatherService;


    /**
     * @Description: 根据城市名获取天气
     * @Params: city【需要获取的城市名称】
     * @Return:
     * @Author: Yellow
     * @Date: 2019/10/17
     */
    @GetMapping("/getWeather")
    public CommonResp getWeather (Weather weather) {
        return weatherService.doGetWeather(weather);
    }


    /**
     * @Description: 不从redis获取数据，重新请求第三方数据，一般用户数据更新
     * @Params:  city【查询的城市名称】
     * @Return:
     * @Author: Yellow
     * @Date: 2019/10/17
     */
    @GetMapping("/getWeatherToughGet")
    public CommonResp getWeatherTough (String city) {
        Weather weather = new Weather();
        weather.setCity(city);
        return weatherService.doGetWeatherTough(weather);
    }

    @GetMapping("/getWeatherToughPost")
    public CommonResp getWeatherTough (@RequestBody Weather weather) {
        return weatherService.doGetWeatherTough(weather);
    }

}
