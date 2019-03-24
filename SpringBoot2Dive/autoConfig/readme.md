# Spring framework manual config

## Spring 模式注解装配 ( Stereotype Annotations)
 ```- 定义： 一种用于声明在应用中扮演组件角色
 - 举例： @Component, @Service, @Configuration, 
         '''
         @Component - 可扫描的候选对象 2.5
         @Service - 也是可扫描候选对象 2.5
         @Controller 2.5
         @Repository  2.0
         @Configuration 3.0 -代替XML 文件
         '''
 - 装配：<context:component-scan> - 2.5
         @ComponentScan - 3.1
 ```
 
 ### 基于xml
 ```<context:annotation-config/>
 <context:component-scan base-package="com.***.***" />
 ```
 
 ### 基于@ComponentScan - Spring boot 1.0 --starts from Spring4.0
 ```@ComponentScan(basePackage="...")
 public class SpringConfiguration{
 }
 ```
 
 ### @Component 派生性
 ```
 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @Repository
 public @interface FirstLevelRepository{
      String value() default "";
 }
 
 //@Repository 派生于@Component
 //FirstLevelRepository 的方法签名，与@Repository相同，与@Component相同
  //String value() default "";
 ```
  * @Component
    * @Repository
      * FirstLevelRepository
 
 
 ### @Component 层次性
 ```
 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @FirstLevelRepository
 public @interface SecondLevelRepository{
 }
 ```
 
 
# Spring boot auto config
