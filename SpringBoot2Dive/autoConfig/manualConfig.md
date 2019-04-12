

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
 
  * annotation本身没有继承、派生机制， 但是相当于派生
  ### @Component 层次性
 ```
 @Target(ElementType.TYPE)
 @Retention(RetentionPolicy.RUNTIME)
 @Documented
 @FirstLevelRepository
 public @interface SecondLevelRepository{
 }
 ```
   * @Component
     * @Repository
       * FirstLevelRepository
         * SecondLevelRepository
 
 ## Spring @Enable 模块装配
  *  定义： 具备相同领域的功能组件集合，组合所形成一个独立的单元
  *  举例： @EnableWebMVC. @EnableAutoConfiguration 等等
  *  实现： 注解方式，编程方式
   ···
   SpringFramework 3.1开始支持@Enable模块驱动。所谓模块是指具备相同领域的功能的组件的集合
   组合所形成一个独立的单元。比如web mvc模块， AspectJ代理模块， Caching（缓存）模块，JMX（Java管理扩展）模块
   Async(异步处理）模块等。   
   ···
     ### @Eable模块注解举例
     框架实现 | @Enable注解模块 | 激活模块  
     --------|----------------|------------
     SpringFramework | @EnableMvc | Web MVC
     | @EnableTransactionManagement | 事务管理
     | @EnableCaching | C aching
     | @EnableMBeanExport | JMX模块
     | @EnableAsync | 异步处理模块
     | @EnableWebFlux | Web Flux模块
     | @EnableAspectJAutoProxy | AspectJ代理模块
     Spring boot | @EnableAutoConfiguration | 自动装配模块
     | @EnableManagementContext | Actuator模块
     | @EnableConfigurationProperties | 配置属性绑定模块
     | @EnableOAuth2Sso |Oauth2单点登录模块
     Spring cloud | @EnableEurekaServer | Eureka服务器模块
     | @EnableConfigServer | 配置服务器模块
     | @EnableFeignClients | Feign客户端模块
     | @EnableZuulProxy | 服务器网关Zuul模块
     | @EnableCircuitBreaker | 服务器熔断模块
   
   ## 实现方式
   
       ### 注解驱动方式
       ```
       public @interface EnableWebMvc - @Import(DelegatingWebMvcConfiguration.class)
       ```
       ```
       @Configuration
       public class DelegatingWebMvcConfiguration extends WebMvcConfigurationSupport
       ```
       
       ### 接口编程方式
       ···
       @Import(CachingConfigurationSelector.class)
       public @interface EnableCaching
       ···

 ## 自定义@Enable模块
 
 ### 基于注解驱动实现 - @EnableHelloWorld
 EnableHelloWorldBootStrap - > EnableHelloWorld -> HelloWorldConfiguration -> HelloWorld
 ### 基于接口驱动实现 - @EableServer - 更灵活，更推荐
 
 EnableHelloWorldBootStrap - > EnableHelloWorld -> HelloWorldImportSelector -> HelloWorldConfiguration  -> HelloWorld
 
 ## Spring条件装配
 * 定义： Bean 装配的前置判断
 * 举例： @Profile, @Conditional
 * 实现： 注解方式，编程方式
 
 从Spring Framework3.1开始，允许在Bean装配前增加前置条件判断
 
 ### 条件注解举例
 Spring注解 | 场景说明 | 
 ----------|--------
 @Profile  | 配置化条件装配 since 3.1
 @Conditional | 编程条件装配 since 4.0
 
 ```
 @Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional({OnClassCondition.class})
public @interface ConditionalOnClass {
    Class<?>[] value() default {};

    String[] name() default {};
}
 ```
 ## 自定义条件装配
 ### 基于配置方式实现 - @Profile -- since 3.1
 计算服务， 多整数求和sum
 @Profile（“java7")" for循环
 @Profile（”java8") Lambda
 Note to add @Service
 
 ### 基于编程方式实现 - @ConditionalOnSystemProperty
    -  @Conditional(OnSystemPropertyCondition.class)
          public @interface ConditionalOnSystemProperty
    -  OnSystemPropertyCondition implements Condition
    -  ConditionalOnSystemPropertyBootStrap
          @Bean
          @ConditionalOnSystemProperty(name="user.name", value="jinniandai")
           public String helloWorld()
    AnnotatedTypeMetadata
