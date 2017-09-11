package com.masith.employee.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

public class SpringInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext sc)throws ServletException {
		
		sc.setInitParameter("contextConfigLocation", "noop");
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(SpringConfig.class);
		sc.addListener(new ContextLoaderListener(context));
		sc.addListener(new RequestContextListener());
		
	}
}
