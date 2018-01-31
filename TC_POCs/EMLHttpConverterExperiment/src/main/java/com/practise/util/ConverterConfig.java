package com.practise.util;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

/**
 * Configuration and overrides for Spring MVC / REST Controllers
 */
@Configuration
public class ConverterConfig extends WebMvcConfigurationSupport {

    /**
     * {@inheritDoc}
     */
    @Override
    protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new CustReceiverHttpMessageConverter());
        super.configureMessageConverters(converters);
    }

}
