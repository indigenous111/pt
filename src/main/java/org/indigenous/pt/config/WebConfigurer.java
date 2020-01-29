package org.indigenous.pt.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.indigenous.pt.interceptors.CORSInterceptor;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfigurer implements ServletContextInitializer,
		WebServerFactoryCustomizer<ConfigurableServletWebServerFactory>, WebMvcConfigurer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		// No Implementation
	}

	@Override
	public void customize(ConfigurableServletWebServerFactory factory) {
		// No Implementation
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new CORSInterceptor());
	}
	
	@Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

}
