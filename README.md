# 야구 관리 프로그램

### 의존성

- Sring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Web


```xml
<!-- JSP 템플릿 엔진 -->
<dependency>
	<groupId>org.apache.tomcat</groupId>
	<artifactId>tomcat-jasper</artifactId>
	<version>9.0.44</version>
</dependency>

<!-- JSTL -->
<dependency>
	<groupId>javax.servlet</groupId>
	<artifactId>jstl</artifactId>
</dependency>
```


### 데이터베이스
```sql
create user 'baseball'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'baseball'@'%';
create database baseball;
```

### yml 설정
```
server:
  port: 8080
  servlet:
    context-path: /
    encoding:
      charset: utf-8
      enabled: true
    
spring:
  mvc:
    view:
      prefix: /WEB-INF/views/
      suffix: .jsp
      
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/baseball?serverTimezone=Asia/Seoul&useSSL=false&allowPublicKeyRetrieval=true
    username: baseball
    password: bitc5600
    
  jpa:
    open-in-view: true
    hibernate:
      ddl-auto: update
      naming:
        physical-strategy: org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl
    show-sql: true
```

### 태그 라이브러리
```
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
```
