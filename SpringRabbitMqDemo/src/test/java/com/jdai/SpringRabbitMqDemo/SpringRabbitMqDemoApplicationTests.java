package com.jdai.SpringRabbitMqDemo;

import com.jdai.SpringRabbitMqDemo.bean.Book;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.AmqpAdmin;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class SpringRabbitMqDemoApplicationTests {
	@Autowired
	RabbitTemplate rabbitTemplate;

	@Autowired
	AmqpAdmin amqpAdmin;
	@Test
	public void createExchange(){
		amqpAdmin.declareExchange(new DirectExchange("amqpadmin.exchange.direct"));
		System.out.println(" create exchange via amqpadim");
	}
	@Test
	void contextLoads() {
		//定制message
		//Message
		//rabbitTemplate.send("jd-rabbitmq", "jd-rabbitmq", );

		//object ,自动序列化
		//content_type:	application/x-java-serialized-object

		//if to jason, config  a Jackson2JsonMessageConverter bean
		//content_type:	application/json
//		Map<String, Object> map = new HashMap<>();
//		map.put("msg", "first mssage");
//		map.put("data", Arrays.asList(1,2 ,3));
//		rabbitTemplate.convertAndSend("exchange.direct", "jd-rabbitmq-news",map);

		//if send object
		Book book1= new Book("bookauthor1", "bookname1");
		rabbitTemplate.convertAndSend("exchange.direct", "jd-rabbitmq-news", book1);
		System.out.println("				------send book to exchange.direct and queue jd-rabbitmq-news");
	}

	@Test
	public void receiveMessage(){
		Object o = rabbitTemplate.receiveAndConvert("jd-rabbitmq-news");
		System.out.println(o.getClass());
		System.out.println(o);
	}

	@Test
	public void fanoutMessage(){
		Book book2= new Book("bookauthor2", "bookname2");
		rabbitTemplate.convertAndSend("exchange.fanout", "", book2);
		System.out.println("				------send book to exchange.fanout and all queues");
	}

}
