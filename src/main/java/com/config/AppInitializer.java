package com.config;

import com.security.SecurityConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class AppInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // root config
        AnnotationConfigWebApplicationContext rootConfig = new AnnotationConfigWebApplicationContext();
        rootConfig.register(RootConfig.class, DbConfig.class, SecurityConfig.class);
        rootConfig.refresh();
        servletContext.addListener(new ContextLoaderListener(rootConfig));

        // servlet config
        AnnotationConfigWebApplicationContext servletConfig = new AnnotationConfigWebApplicationContext();
        servletConfig.register(ServletConfig.class);
        ServletRegistration.Dynamic registration = servletContext.addServlet("servlet",new DispatcherServlet(servletConfig));

        // set load on startup
        registration.setLoadOnStartup(1);

        // mapping
        registration.addMapping("/");
    }
}
