# Relational database

# Relational database

- JDBC
  1) dependency      

  ```
  <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-jdbc/artifactId>
  </dependency>
  ```

  2） javax.sql.Datasource

  ​     JDBCTemplate

  3） autoconfig

     org.springframework.boot.autoconfigure.jdbc
     DataSourceAutoConfiguration
     JdbcTemplateConfiguration

- JPA

  - ```
    <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency>
    ```

  - Note that spring-boot-starter-data-jpa not conflict with jdbc

- Transactions
