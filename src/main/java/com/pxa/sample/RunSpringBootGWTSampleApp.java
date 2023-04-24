package com.pxa.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * @author <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since 2018-01-10 19:06
 */
@SpringBootApplication
@ServletComponentScan
public class RunSpringBootGWTSampleApp extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(RunSpringBootGWTSampleApp.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(RunSpringBootGWTSampleApp.class);
    }
}