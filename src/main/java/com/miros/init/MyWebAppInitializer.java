package com.miros.init;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class MyWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return null;
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {

		System.out.println("ServletConfig");

		return new Class<?>[] { SpringMvcConfig.class };
	}

	@Override
	protected String[] getServletMappings() {

		System.out.println("ServletMapping");

		return new String[] { "/" };
	}
}
