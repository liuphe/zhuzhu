package com.zhuzhu.parent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication//Spring Boot核心注解，用于开启自动配置
public class ParentApplication {
	@RequestMapping("/")
    String index(){
      return "Hello Spring Boot";
    }
	public static void main(String[] args) {
		SpringApplication.run(ParentApplication.class, args);
	}
}
