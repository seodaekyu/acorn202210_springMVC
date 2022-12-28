package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * 	어떤 객체를 spring 이 생성해서 관리할지 설정할지 설정( bean 설정 )
 */
@Configuration
public class JavaConfig {
	
	// 이 메소드에서 리턴되는 객체를 spring 이 관리하는 bean 이 되도록한다.
	// 아래의 메소드는 xml 문서에서 <bean id="myCar" class="com.example.demo.car" /> 와 같다.
	@Bean
	public Car myCar() { // method 의 이름은 bean 의 이름 역할을 한다.
		System.out.println("myCar 메소드 호출됨!");
		Car c1 = new Car();
		return c1;
	}
}
