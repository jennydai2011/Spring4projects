package com.jdai.diveIntoBoot.bootstrap;

import com.jdai.diveIntoBoot.condition.ConditionalOnSystemProperty;
import com.jdai.diveIntoBoot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

//@ConditionalOnSystemProperty(name="user.name", value="jinniandai")
public class ConditionalOnSystemPropertyBootStrap {

    @Bean
    @ConditionalOnSystemProperty(name="user.name", value="jinniandai")
    public String helloWorld(){
        return "Hello world, jdai";
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(ConditionalOnSystemPropertyBootStrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        //get bean
        String helloWorld=context.getBean("helloWorld", String.class);

        //close context
        context.close();
    }
}
