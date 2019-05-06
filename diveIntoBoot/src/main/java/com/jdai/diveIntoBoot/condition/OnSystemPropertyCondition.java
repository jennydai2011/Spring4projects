package com.jdai.diveIntoBoot.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSystemPropertyCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {

        Map<String, Object> attributes= metadata.getAnnotationAttributes(ConditionalOnSystemProperty.class.getName());

        String propertyName = String.valueOf(attributes.get("name"));
        String propertyvalue = String.valueOf(attributes.get("value"));

        String javaPropertyValues = System.getProperty(propertyName);


        return propertyvalue.equals(javaPropertyValues);
    }
}
