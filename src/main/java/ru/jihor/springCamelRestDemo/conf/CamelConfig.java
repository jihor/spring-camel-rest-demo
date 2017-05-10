package ru.jihor.springCamelRestDemo.conf;

import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Configuration
public class CamelConfig {
    @Bean
    public ServletRegistrationBean camelServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/rest-api/*");
        registration.setName("CamelServlet");
        return registration;
    }
}
