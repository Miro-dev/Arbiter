package com.miros.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("SecurityConfig");
		return new Class[] { SecurityConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		System.out.println("ServletConfig");

		return new Class<?>[] { SpringMVCConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		System.out.println("ServletMapping");

		return new String[] { "/" };
	}
}

// Security branch
