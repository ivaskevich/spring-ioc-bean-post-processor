package com.bobocode.lib;

import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StringTrimmingConfiguration {
    @Bean
    public BeanPostProcessor stringTrimmingPostProcessor() {
        return new TrimmedAnnotationBeanPostProcessor();
    }
}
