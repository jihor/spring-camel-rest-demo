package ru.jihor.springCamelRestDemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jihor on 6/17/17.
 */
@EnableWebSecurity
@Configuration
public class DemoWebSecurityConfigurerAdapter extends
        WebSecurityConfigurerAdapter {
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
           .antMatchers("/docs", "/rest/docs", "/swagger-ui.html", "/webjars/**", "/swagger-resources/**");
    }
}