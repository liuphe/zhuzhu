package com.zhuzhu.parent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.web.servlet.ErrorPage;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.zhuzhu.filter.RewriteFilter;


@ComponentScan(basePackages={"com.zhuzhu"}) // 扫描该包路径下的所有spring组件
@SpringBootApplication
@EnableScheduling
public class SpringBootMainApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootMainApplication.class, args);
	}

	@Bean
	public EmbeddedServletContainerCustomizer containerCustomizer() {
		return new EmbeddedServletContainerCustomizer() {
			public void customize(ConfigurableEmbeddedServletContainer container) {
				container.addErrorPages(new ErrorPage(HttpStatus.UNAUTHORIZED,
						"/errors/401.html"));
				container.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND,
						"/errors/404.html"));
				container.addErrorPages(new ErrorPage(
						HttpStatus.INTERNAL_SERVER_ERROR, "/errors/500.html"));
			}
		};
	}

	@Bean
	public FilterRegistrationBean testFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean();
		registration.setFilter(new RewriteFilter());// 注册rewrite过滤器
		registration.addUrlPatterns("/*");
		registration.addInitParameter(RewriteFilter.REWRITE_TO, "/index.html");
		registration.addInitParameter(RewriteFilter.REWRITE_PATTERNS, "/ui/*");
		registration.setName("rewriteFilter");
		registration.setOrder(1);
		return registration;
	}
}
