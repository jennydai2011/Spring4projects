#  Spring Boot 自动装配

-  定义： 基于约定大于配置的原则， 实现组件自动装配
    比手动装配的优点： 不需要手动装配

-  装配： 模式注解， @Enable 模块， 条件装配， 工厂加载机制

-  实现: 激活自动装配，实现自动装配，配置自动装配


## 底层装配技术
-  Spring模式注解装配
-  Spring @Enable 模块装配
-  Spring 条件装配装配
-  Spring 工厂加载机制装配
    -  实现类： SpringFactoriesLoader
    -  配置资源： META-INF/spring.factories
    
## 自动装配举例
参考 META-INF/spring.factories
