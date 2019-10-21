package cn.yellow948.job;

import cn.yellow948.dto.CommonResp;
import cn.yellow948.service.GetWeatherCollectionService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;


public class WeatherDataSyncJob extends QuartzJobBean {

	@Autowired
	private RedisTemplate<String ,String> redisTemplate;

	@Autowired
	private GetWeatherCollectionService getWeatherCollectionService;


	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date begin = new Date();
		System.out.println(sdf.format(begin) + " 定时任务开始执行!");
		int num = 0;
		Set<String> keys = redisTemplate.keys("city*");
		for (String str : keys) {
			if (redisTemplate.hasKey(str) && !str.equals("city-null")) {
				// 获取最新数据
//				Weather weather = new Weather();
//				weather.setCity(str.split("-")[1]);
				CommonResp resp = getWeatherCollectionService.refresh(str.split("-")[1]);
				num++;
			}
		}
		Date end = new Date();
		System.out.println(sdf.format(begin) + " 定时任务执行结束！共更新了 "+ num + " 条数据");
	}

}
