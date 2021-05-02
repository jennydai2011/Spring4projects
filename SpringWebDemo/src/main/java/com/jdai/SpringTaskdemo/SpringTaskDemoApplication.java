package com.jdai.SpringTaskdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * How to return to last file in Intellij-- choose which one works best for you:
 *
 * Navigate | Back
 * Navigate | Last Edit Location
 * View | Recent Files
 * Ctrl+Tab (switch to the last (most recent) tab -- similar how Alt+Tab works)
 */
@EnableScheduling //开启定时任务
@EnableAsync//开启异步注解功能
@SpringBootApplication
public class SpringTaskDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringTaskDemoApplication.class, args);
	}

}
