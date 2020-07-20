package com.miros.init;

import java.sql.SQLException;
import java.util.Properties;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.miros.web.StaticHelpers;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.miros")
@EnableTransactionManagement
public class SpringMVCConfig implements WebMvcConfigurer {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/ardeos_corporation");
		dataSource.setUsername("root");
		dataSource.setPassword("246135");

		return dataSource;
	}

	@Bean
	public EntityManagerFactory entityManagerFactory() throws SQLException {
		LocalContainerEntityManagerFactoryBean lcemf = new LocalContainerEntityManagerFactoryBean();
		lcemf.setDataSource(dataSource());
		lcemf.setPackagesToScan(new String[] { "com.miros" });

		JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		lcemf.setJpaVendorAdapter(vendorAdapter);
		lcemf.setJpaProperties(additionalProperties());
		lcemf.afterPropertiesSet();

		System.out.println("LCEMF: " + lcemf);

		return lcemf.getObject();
	}

	@Bean
	public PlatformTransactionManager transactionManager() throws SQLException {
		JpaTransactionManager transactionManager = new JpaTransactionManager();
		transactionManager.setEntityManagerFactory(entityManagerFactory());

		return transactionManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties additionalProperties() {
		System.out.println("Addition ");
		Properties properties = new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "create-drop");
		properties.setProperty("show_sql", "true");
		properties.setProperty("hibernate.temp.use_jdbc_metadata_defaults", "false");
		properties.setProperty("hibernate.format_sql", "true");
		properties.setProperty("hibernate.use_sql_comments", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");

		return properties;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

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
		System.out.println("Bean StaticHelper Created!");
		return new StaticHelpers();
	}

	// This is for using persistence.xml file for configuration. Now it is done in "Properties additionalProperties()" and "DataSource dataSource()"
//	@Bean
//	public EntityManagerFactory getEntityManagerFactory() throws Exception {
//		System.out.println("EntityManagerFactory Creation.");
//		return Persistence.createEntityManagerFactory("MyPersistence");
//	}
}
