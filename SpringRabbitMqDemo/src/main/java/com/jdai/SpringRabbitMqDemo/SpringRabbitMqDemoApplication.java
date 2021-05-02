package com.jdai.SpringRabbitMqDemo;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ 自动配置
 * 1. RabbitAutoConfiguration
 * 2. 自动配置了连接工厂 ConnectionFactory
 * 3. RabbitProperties 封装了RabbitMQ的配置,prefix = "spring.rabbitmq"
 * 4. RabbitTemplate： 发送接收消息
 * 5. AmqpAdmin 系统管理组件
 * 		create/edit exchange + queue
 * 6. @EnableRabbit + @RabbitListener(queues ="jd-rabbitmq-news")
 *
 */
@EnableRabbit
@SpringBootApplication
public class SpringRabbitMqDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringRabbitMqDemoApplication.class, args);
	}

}
