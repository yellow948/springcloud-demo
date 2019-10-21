package cn.yellow948.service;


import cn.yellow948.dto.CommonResp;
import cn.yellow948.entity.Weather;
import cn.yellow948.utils.WeatherDataUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;


@Service
public class WeatherServiceImpl {

    @Autowired
    private RedisTemplate<String ,String> redisTemplate;

    public CommonResp doGetWeather (Weather weather) {
//        String key = DigestUtils.md5DigestAsHex(weather.getCity().getBytes());
        String key = "city-"+weather.getCity();
        Weather weatherRe = null;
        ObjectMapper mapper = new ObjectMapper();
        if (redisTemplate.hasKey(key)) {
            // redis存在数据
            String value = redisTemplate.opsForValue().get(key);
            try {
                weatherRe = mapper.readValue(value, Weather.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            weatherRe = new WeatherDataUtil().getWeatherDataByCity(weather);
            String value = "";
            try {
                value = mapper.writeValueAsString(weatherRe);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            redisTemplate.opsForValue().set(key, value);
        }

        return new CommonResp(200, "ok", weatherRe);
    }


    public CommonResp doGetWeatherTough (Weather weather) {
//        System.out.println("被调用"+weather.getCity());
        // 获取最新数据 插入redis
        Weather weatherRe = new WeatherDataUtil().getWeatherDataByCity(weather);
        String value = "";
        String key = "city-" + weather.getCity();
        try {
            ObjectMapper mapper = new ObjectMapper();
            value = mapper.writeValueAsString(weatherRe);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        redisTemplate.opsForValue().set(key, value);
        return new CommonResp(200, "ok", weatherRe);
    }
}
