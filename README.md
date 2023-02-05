# Spring Security
- 기본적인 로그인 기능을 구현

## 📌 SecurityConfig class
- spring security의 기본 로그인 설정
- WebSecurityConfigurerAdapter는 deprecate 되었기 때문에 SecurityFilterChain과 다른 Customizer를 ```@Bean``` 으로 등록하여 사용

### 1. [SecurityFilterChain]
![security configuration-filter chain](https://user-images.githubusercontent.com/87001865/216809818-99417db1-cc40-4bb1-bd33-6743456ffab4.png)

<br>

## 📌 UserService class
- saveUser method 수정

### [saveUser] 
- 기본 권한인 "ROLE_USER", enabled, Password는 BCryptPasswordEncoder를 통해 암호화하여 user 객체 저장

![saveUser](https://user-images.githubusercontent.com/87001865/216818932-71cefe64-4747-4647-828e-1aacf693364d.png)


#### - [결과]
![saveUser 결과](https://user-images.githubusercontent.com/87001865/216819102-0915de0d-9149-4f81-8696-7ef4b3949d28.png)

<br>

## 📌 오류
- loginAccessTest 중 아래의 오류 발생

![test오류](https://user-images.githubusercontent.com/87001865/216809803-401182f5-30d3-48c5-9132-6412be5c2494.png)

<br>

- 원인

 => MockMvc를 통해 test를 하기 위한 어노테이션 ```@WebMvcTest(UserController.class)``` 이 JpaAuditing을 인식하지 못해 발생
 
 ![UserControllerTest](https://user-images.githubusercontent.com/87001865/216819379-d399db77-8a60-4ad7-89b8-acc5a555aae7.png)

<br>
 
- 해결

 => JpaAuditing을 따로 분리하여 ```@Configuration``` 설정

![JpaAuditingConfig](https://user-images.githubusercontent.com/87001865/216819386-6814b612-cc0b-429e-8961-6630138579b0.png)



