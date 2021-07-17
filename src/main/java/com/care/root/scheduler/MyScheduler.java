package com.care.root.scheduler;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class MyScheduler {
	//@Scheduled(cron = "*/10 * * * * *") //10초에 한 번씩 실행됨.
	public void scheduled() {
		System.out.println("=== 실행 ===");
	}
	
}
