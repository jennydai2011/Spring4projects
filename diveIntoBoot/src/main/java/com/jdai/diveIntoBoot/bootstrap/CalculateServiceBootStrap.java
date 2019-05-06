package com.jdai.diveIntoBoot.bootstrap;

import com.jdai.diveIntoBoot.service.CalculateService;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * {@link com.jdai.diveIntoBoot.service.CalculateService} 引导类
 */
@SpringBootApplication(scanBasePackages = "com.jdai.diveIntoBoot.service")
public class CalculateServiceBootStrap {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(CalculateServiceBootStrap.class)
                .web(WebApplicationType.NONE)
                .profiles("Java8")
                .run(args);

        //get bean
        CalculateService service= context.getBean(CalculateService.class);

        System.out.println("calculateService.sum(1...10)" + service.sum(1,2,3,4,5,6,7,8,9,10));

        //close context
        context.close();
    }
}

