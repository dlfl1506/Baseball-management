# 야구 관리 프로그램

### 의존성

- Sring Boot DevTools
- Lombok
- Spring Data JPA
- MySQL Driver
- Spring Web
- QLRM

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


### ✔ 기능

<img src="https://user-images.githubusercontent.com/74044212/112508840-40d13380-8dd3-11eb-9629-bbfca45ad0ae.png"  width="100%" /><br/>

#### 1.야구장등록
#### 2.팀등록
#### 3.선수등록
#### 4.야구장리스트보여주기
#### 5.팀리스트보여주기
#### 6.선수리스트보여주기



### 포지션별 선수명단뿌리기
<img src="https://user-images.githubusercontent.com/74044212/112509101-7f66ee00-8dd3-11eb-9b12-060f41a5f693.png"  width="100%" /><br/>


### 서버 실행화면
![ezgif com-gif-maker (1)](https://user-images.githubusercontent.com/74044212/112511566-e08fc100-8dd5-11eb-9864-193584490ee3.gif)

