package com.pxa.sample.springboot.gwt;

import com.pxa.sample.springboot.gwt.server.web.RPCServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @author: <a href="mailto:xiaoan.pan@qq.com">潘小安</a>
 * @since: 2018-01-10 19:06
 */
@SpringBootApplication
public class RunSpringBootGWTSampleApplication {

	@Bean
	public ServletRegistrationBean servletRegistrationBean() {
		return new ServletRegistrationBean(new RPCServlet(), "/www/rpc/*");
	}

	public static void main(String[] args) {
		SpringApplication.run(RunSpringBootGWTSampleApplication.class, args);
	}
}
