package cn.yellow948.dto;

import lombok.Data;


@Data
public class WeatherResp<T> {
    private Integer status;
    private String desc;
    private T data;
}
