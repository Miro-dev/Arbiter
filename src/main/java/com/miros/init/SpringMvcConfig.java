package com.miros.init;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.miros.DB.EntityManagerFactoryDAO;
import com.miros.web.StaticHelpers;

// Create the CreateAccount Functionality

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.miros")
public class SpringMvcConfig implements WebMvcConfigurer {

	@Bean
	public ViewResolver viewResolver() {

		System.out.println("Resolver");

		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		System.out.println("Handler");

		registry.addResourceHandler("/resources/**").addResourceLocations("/resources");
	}

	@Bean
	public StaticHelpers getStaticHelpers() {

		{
			System.out.println("Bean StaticHelper Created!");
		}

		return new StaticHelpers();
	}

	@Bean
	public EntityManagerFactoryDAO getEntityManagerFactoryDAO() throws Exception {

		{
			System.out.println("EntityManagerFactoryDAO Creation.");
		}

		return new EntityManagerFactoryDAO();
	}
}
