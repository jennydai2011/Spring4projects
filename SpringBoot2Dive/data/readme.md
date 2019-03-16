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

  - Note that spring-boot-starter-data-jpa depends on jdbc and not conflict with jdbc

  - relationship mapping

    - @javax.persistence.OneToOne
    - @javax.persistence.OneToMany
    - @javax.persistence.ManyToOne
    - @javax.persistence.ManyToMany

  - javax.persistence.EntityManager

    - EntityManagerFactoryBuilder
    - DefaultpersistenceUnitManager

  - Autoconfiguration

  - ```
    HibernateJpaAutoConfiguration
    ```

- Transactions

  1. Dependency

     ```
     <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-tx</artifactId>
     </dependency>
     ```

  2. Spring trasaction manager

     1. PlatformTransactionManager

  3. JDBC transaction

     1. DataSourceTransactionManager

  4. AutoConfig

     - TransactionAutoConfiguration
