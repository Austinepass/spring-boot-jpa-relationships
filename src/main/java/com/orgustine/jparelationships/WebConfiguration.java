package com.orgustine.jparelationships;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Allows us to display the h2 database in the browser
 */
@Configuration
public class WebConfiguration {
//    @Bean
//    ServletRegistrationBean h2servletRegistration() {
//        ServletRegistrationBean registrationBean =
//                new ServletRegistrationBean(new WebServlet());
//        registrationBean.addUrlMappings("/console/*");
//        return registrationBean;
//    }
}
