package com.zhuzhu.config;

import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureAfter(MybatisConfig.class)
public class MyBatisMapperScannerConfig {
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer() {
		MapperScannerConfigurer mapperScannerConfigurer = new MapperScannerConfigurer();
		// 获取之前注入的beanName为sqlSessionFactory的对象
		mapperScannerConfigurer
				.setSqlSessionFactoryBeanName("sqlSessionFactoryBeanName");
		// 指定xml配置文件的路径
		mapperScannerConfigurer.setBasePackage("com.zhuzhu.dao");
		return mapperScannerConfigurer;
	}
}