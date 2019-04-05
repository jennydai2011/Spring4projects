package com.jdai.diveIntoBoot.annotation;

import com.jdai.diveIntoBoot.configuration.HelloWorldConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sun.jvm.hotspot.HelloWorld;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Configuration
//@Import(HelloWorldConfiguration.class)
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {
}
