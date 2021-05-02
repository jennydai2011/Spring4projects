package com.jdai.SpringTaskdemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	JavaMailSenderImpl mailSender;

	@Test
	void contextLoads() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("Test Spring email sending....");
		message.setText("Email content");
		message.setTo("jennydai1974@gmail.com");
		message.setFrom("jennydai2011@gmail.com");
		mailSender.send(message);
	}

}
