package com.example.config;

import javax.servlet.ServletRegistration.Dynamic;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * Java configuration file that is used for web application initialization
 */
public class WebApp extends AbstractAnnotationConfigDispatcherServletInitializer {

    public WebApp() {
        super();
    }

    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] { RepositoryConfig.class/*, WebMVCSecurity.class, InitSecurity.class*/ };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebMVCConfig.class/*, WebMVCSecurity.class, InitSecurity.class*/ };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected void customizeRegistration(final Dynamic registration) {
        super.customizeRegistration(registration);
    }

}
