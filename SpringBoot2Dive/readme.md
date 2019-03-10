video: https://www.youtube.com/watch?v=s3eN0LJ2MK8&list=PL9avoKyUyEuw_Dnx3sUekm6EUIfO65HtE&index=7

another blog set: https://www.cnblogs.com/ityouknow/p/5662753.html

# New Document
Notes
1. old web app
   config web.xml - Servlet, Filter, Listener   
   config spring
   config datasource
   config properties
   config spring annotation scan
   
   	1）配置web.xml，加载spring和spring mvc

	2）配置数据库连接、配置spring事务

	3）配置加载配置文件的读取，开启注解

	4）配置日志文件

2.Spring boot 

	+- example
    +- myproject
      +- Application.java
      |
      +- domain
      |  +- Customer.java
      |  +- CustomerRepository.java
      |
      +- service
      |  +- CustomerService.java
      |
      +- controller
      |  +- CustomerController.java         
   
      
  3. pom.xml
  
  pom.xml文件中默认有两个模块：

	spring-boot-starter：核心模块，包括自动配置支持、日志和YAML；

	spring-boot-starter-test：测试模块，包括JUnit、Hamcrest、Mockito
  4. controller
  	@RestController take care of jason, no need to config jackson
  5.Traditional web servlet in SpringBoot app
	1. @WebServlet, doGet, doPost
	2. @ServletComponentScan
