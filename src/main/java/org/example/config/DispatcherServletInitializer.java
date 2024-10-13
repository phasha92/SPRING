package org.example.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Configuration
@EnableWebMvc
public class DispatcherServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    Logger logger = LoggerFactory.getLogger(DispatcherServletInitializer.class);
    @Override
    protected Class<?>[] getRootConfigClasses() {
        logger.info("rootConfigClasses");
        return new Class[]{DatabaseConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        logger.info("servletConfigClasses");
        return new Class[]{AppConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        logger.info("servletMappings");
        return new String[]{"/"};
    }

}
