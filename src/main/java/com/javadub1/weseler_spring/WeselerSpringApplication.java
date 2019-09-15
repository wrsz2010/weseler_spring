package com.javadub1.weseler_spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import javax.annotation.PostConstruct;

@SpringBootApplication
public class WeselerSpringApplication {

	@Autowired
	private HelloBean helloBean;

	public static void main(String[] args) {
		SpringApplication.run(WeselerSpringApplication.class, args);
	}
	@PostConstruct
	public void run() {
		helloBean.hello();
	}
}
