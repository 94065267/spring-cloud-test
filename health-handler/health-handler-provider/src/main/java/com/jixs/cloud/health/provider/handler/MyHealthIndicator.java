package com.jixs.cloud.health.provider.handler;

import com.jixs.cloud.health.provider.controller.HealthController;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * 健康指示器
 * @author jixs
 *
 */
@Component
public class MyHealthIndicator implements HealthIndicator {

	@Override
	public Health health() {
		if(HealthController.canVisitDb) {
			// //自定义监控内容 成功连接数据库，返回UP
			return new Health.Builder().withDetail("aaa_cnt", 10)
					.withDetail("bbb_status", "up").up().build();
		} else {
			// 连接数据库失败，返回 out of service
			return new Health.Builder().withDetail("error", "client is down").down().build();
		}
	}
}
