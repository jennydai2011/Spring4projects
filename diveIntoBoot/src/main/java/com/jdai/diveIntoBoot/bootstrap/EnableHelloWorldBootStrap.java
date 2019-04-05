package com.jdai.diveIntoBoot.bootstrap;

import com.jdai.diveIntoBoot.annotation.EnableHelloWorld;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

@EnableHelloWorld
public class EnableHelloWorldBootStrap {

    public static void main(String[] args){
        ConfigurableApplicationContext context =
                new SpringApplicationBuilder(EnableHelloWorld.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //helloWorld bean

        String helloWorld = context.getBean("helloWorld", String.class);

        System.out.println("helloWorld bean : " + helloWorld);

        //close context
        context.close();


    }
}
