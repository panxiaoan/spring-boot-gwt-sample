package com.pxa.sample.springboot.gwt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-10 19:06
 */
@SpringBootApplication
@ServletComponentScan
public class RunSpringBootGWTSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(RunSpringBootGWTSampleApplication.class, args);
	}
}
