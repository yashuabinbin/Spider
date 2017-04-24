package com.example.configs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import javax.servlet.ServletContext;

/**
 * Created by lbb on 2017/4/24.
 */
@Component
public class VersionConfiguration implements ServletContextAware {

    Logger logger = LoggerFactory.getLogger(this.getClass());


    @Value(value = "${version}")
    private String version;


    @Override
    public void setServletContext(ServletContext servletContext) {
        logger.info("verson: {}", version);
        servletContext.setAttribute("version", version);
    }
}
