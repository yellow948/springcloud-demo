package cn.yellow948.utils;


import cn.yellow948.entity.Weather;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;


public class WeatherDataUtil {

    private static final String WEATHER_URI = "https://www.tianqiapi.com/api?appid=34634593&appsecret=uPj1Ze8I&version=v61&";

    // 不生效
//    @Autowired
//    public RestTemplate restTemplate;

    public Weather getWeatherDataByCity (Weather weather) {
        String city = weather.getCity();
//        try {
//            city = URLEncoder.encode(city, "UTF-8");
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
        String uri = WEATHER_URI + "city=" + city;

        Weather resp = null;
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        if (respString.getStatusCodeValue() == 200) {
            String strBody = respString.getBody();
            try {
                ObjectMapper mapper = new ObjectMapper();
                resp = mapper.readValue(strBody, Weather.class);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return resp;
    }


}
