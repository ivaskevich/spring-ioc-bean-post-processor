package com.bobocode.demo.annotation;

import com.bobocode.lib.StringTrimmingConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Configuration
@Retention(RetentionPolicy.RUNTIME)
@Import(StringTrimmingConfiguration.class)
public @interface EnableStringTrimming {
}
