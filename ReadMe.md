# JPA、Swagger和JWT的快速集成

这次由于项目里使用到里这三个模块，但是我都没有看过，所以借着周末的空闲一次性集成这三个我没有使用过的模块，写一个小Demo。当然快速集成工具和IOC框架使用的是SpringBoot成品是一个使用jwt做权限访问控制的SSO的模块。

## 1. JPA

1. **导入相关依赖**
   按照国际惯例，先要导入相关的依赖。JPA的相关依赖在SpringBoot中有完成度很高的集成，导入依赖的时候十分方便

   ```xml
   <!--JAP相关依赖-->
   <dependency>
       <groupId>org.springframework.boot</groupId>
       <artifactId>spring-boot-starter-data-jpa</artifactId>
   </dependency>
   
   <!--数据库连接池-->
   <dependency>
       <groupId>mysql</groupId>
       <artifactId>mysql-connector-java</artifactId>
       <scope>runtime</scope>
   </dependency>
   
   <!--lombok模块，用于简化Entuty的代码-->
   <dependency>
       <groupId>org.projectlombok</groupId>
       <artifactId>lombok</artifactId>
       <optional>true</optional>
   </dependency>
   ```

2. **添加相关参数**

   需要配置的application.properties的相关参数如下

   ```properties
   #数据源的相关配置
   spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
   spring.datasource.username=root
   spring.datasource.password=Libi.981206
   spring.datasource.url=jdbc:mysql://192.168.3.203:3306/jpa?charset=utf8mb4&useSSL=false
   
   #连接池（Hikari）的相关配置单
   spring.datasource.hikari.maximum-pool-size=20
   spring.datasource.hikari.minimum-idle=5
   
   #JPA相关配置
   spring.jpa.database-platform=org.hibernate.dialect.MySQL5InnoDBDialect
   spring.jpa.show-sql=true
   spring.jpa.hibernate.ddl-auto=create
   ```

   * **spring.jpa.show-sql**表示是否在日志里打印实际运行的sql代码
   * **spring.jpa.hibernate.ddl-auto**表示运行时对数据库的改动逻辑，
     * **create**表示会删除数据库的所有表并且再次重建实体表。这个参数很危险，因为他会把对应的表删除掉然后重建。所以千万不要在生成环境中使用。只有在测试环境中，一开始初始化数据库结构的时候才能使用一次。
     * **update**这个参数表示会进行更新而不会删除表，所以在在非第一次运行时需要换成这个参数

3. **创建一个实体类**

   举例一个实体类如下

   ```java
   @Entity
   @Table(name = "jpa_user")
   @Getter
   @Setter
   @NoArgsConstructor
   @AllArgsConstructor
   public class UserEntity {
   
       @Id
       @Column(name = "user_id", unique = true, columnDefinition = ("varchar(255) comment '用户的ID'"))
       private Long userId;
   
       @Column(name = "user_name", unique = true, columnDefinition = ("varchar(255) not null comment '用户名'"))
       private String userName;
   
       @Column(name = "password",columnDefinition = ("char(60) not null comment '用户的密码'"))
       private String password;
   
       @Column(name = "neck_name",columnDefinition = ("varchar(255) not null comment '昵称'"))
       private String neckName;
   
       @Column(name = "phone", unique = true, columnDefinition = ("varchar(50) not null comment '用户的手机号'"))
       private String phone;
   
       @Column(name = "create_time")
       private Long createTime;
   }
   ```

   需要注意的点如下

   * `@Entity`,`@Colunm`,`@Id`,`@Table`这些注解都是javax.persistence包下的，而不是hibernate相关的包
   * `@Entity` 是一个必选的注解，声明这个类对应了一个数据库表。
   * `@Table(name = "user_name")` 是一个可选的注解。声明了数据库实体对应的表信息。包括表名称、索引信息等。这里声明这个实体类对应的表名是 AUTH_USER。如果没有指定，则表名和实体的名称保持一致。
   * `@Id` 注解声明了实体唯一标识对应的属性。
   * `@Column(length = 32)` 用来声明实体属性的表字段的定义。默认的实体每个属性都对应了表的一个字段。字段的名称默认和属性名称保持一致（并不一定相等）。字段的类型根据实体属性类型自动推断。这里主要是声明了字符字段的长度。如果不这么声明，则系统会采用 255 作为该字段的长度
   * `unique`表示是否唯一，`colunmnDefinition`可以添加相关的相关的信息，相当于自己写建表语句
   * `colunmnDefinition`一定要在语句上加上括号，否则会出现不可预料的问题

   **这时启动这个项目，就可以吧表建好。**当我们看见下面的日志的时候，就说明表已经建好了

   >Hibernate: drop table if exists jpa_user
   >Hibernate: create table jpa_user (user_id varchar(255) comment '用户的ID' not null, create_time bigint, neck_name varchar(255) not null comment '昵称', password char(60) not null comment '用户的密码', phone varchar(50) not null comment '用户的手机号', user_name varchar(255) not null comment '用户名', primary key (user_id)) engine=InnoDB

