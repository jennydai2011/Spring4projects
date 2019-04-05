package com.jdai.diveIntoBoot.bootstrap;

import com.jdai.diveIntoBoot.repository.MyFirstLevelRepository;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

//@EnableAutoConfiguration //option#1
@ComponentScan(basePackages = "com.jdai.diveIntoBoot.repository")

public class RepositoryBootStrap {

    public static void main(String[] args){
        //topion#1 - pass in RepositoryBootStrap.class)
        ConfigurableApplicationContext context = new SpringApplicationBuilder(RepositoryBootStrap.class)//option#1
                .web(WebApplicationType.NONE)
                .run(args);

        //option#2 - component scan
        MyFirstLevelRepository myFirstLevelRepository =
                context.getBean("myFirstLevelRepository", MyFirstLevelRepository.class); //no need to case

        System.out.println("myFirstLevelRepository: "+ myFirstLevelRepository.toString());
        //关闭 上下文
        context.close();
    }
}
