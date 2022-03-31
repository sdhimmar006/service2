package com.example.demo;

//import brave.SpanCustomizer;
import com.google.cloud.logging.Logging;
import com.google.cloud.logging.LoggingOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@SpringBootApplication
public class Service2  {

	public static void main(String[] args) {
//		LoggingOptions.Builder optionsBuilder = LoggingOptions.newBuilder();
//		System.out.println("optionsBuilder:::"+optionsBuilder);
//		Logging logging = optionsBuilder.setProjectId("qwiklabs-gcp-01-fbfb6600dfc0").build().getService();
		SpringApplication.run(Service2.class, args);
	}

//	@Autowired
//	private SpanCustomizer spanCustomizer;

//	@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		registry.addInterceptor(
//				new HandlerInterceptor() {
//					@Override
//					public boolean preHandle(
//							HttpServletRequest request, HttpServletResponse response, Object handler) {
//						spanCustomizer.tag("uuid", UUID.randomUUID().toString());
//						return true;
//					}
//				});
//	}
}
