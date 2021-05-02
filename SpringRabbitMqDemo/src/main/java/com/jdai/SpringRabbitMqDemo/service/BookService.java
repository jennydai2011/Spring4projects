package com.jdai.SpringRabbitMqDemo.service;

import com.jdai.SpringRabbitMqDemo.bean.Book;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @RabbitListener(queues ="jd-rabbitmq-news")
    public void receive(Book book){
        System.out.println("        ======received book from queue======:" + book);
        //will NOT delete message after receive??
    }

    @RabbitListener(queues ="jd-rabbitmq")
    public void receive2(Message message){
        System.out.println("        ======body======:" + message.getBody());
        System.out.println("        ======properties======:" + message.getMessageProperties());
        //will delete message after receive
    }
}

