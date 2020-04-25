package com.miros.web.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.miros.DB.OrderDAO;
import com.miros.web.AOP;
import com.miros.web.StaticHelpers;

@Configuration
@EnableWebMvc
@ComponentScan
public class WebMvcConfig implements WebMvcConfigurer {

	@Bean
	public InternalResourceViewResolver resolver() {

		{
			System.out.println("ResourceViewerCreated!");
		}

		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setViewClass(JstlView.class);
		resolver.setPrefix("/WEB-INF/views/");
		resolver.setSuffix(".jsp");
		return resolver;
	}

	@Bean
	public AOP getAOP() {

		{
			System.out.println("Bean AOP Created! 1");
		}

		return new AOP();
	}

	@Bean
	public OrderDAO getOrderDAO(StaticHelpers staticHelpers) {

		{
			System.out.println("Bean OrderAOP Created! 2");
		}

		return new OrderDAO(staticHelpers);
	}

	@Bean
	public StaticHelpers getStaticHelpers() {

		{
			System.out.println("Bean StaticHelper Created! 3");
		}

		return new StaticHelpers();
	}
}
