package com.example.configs;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by lbb on 2017/4/23.
 */
@Configuration
public class StaticResourceConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/js/**").addResourceLocations("classpath:/WEB-INF/js/");
        registry.addResourceHandler("/css/**").addResourceLocations("classpath:/WEB-INF/css/");
        registry.addResourceHandler("/plugins/**").addResourceLocations("classpath:/WEB-INF/plugins/");
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/WEB-INF/images/");
    }

}
