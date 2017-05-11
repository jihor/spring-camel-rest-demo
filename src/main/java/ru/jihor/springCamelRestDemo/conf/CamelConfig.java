package ru.jihor.springCamelRestDemo.conf;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.servlet.CamelHttpTransportServlet;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.jihor.springCamelRestDemo.model.req.DemoRequest;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Configuration
public class CamelConfig {
    @Bean
    public ServletRegistrationBean camelServletRegistrationBean() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new CamelHttpTransportServlet(), "/rest/*");
        registration.setName("CamelServlet");
        return registration;
    }

    @Bean
    public RouteBuilder routeBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                // Demo config can be seen at
                // https://github.com/apache/camel/blob/master/examples/camel-example-swagger-cdi/src/main/java/org/apache/camel/example/cdi/UserRouteBuilder.java

                // Main config
                restConfiguration()
                        .contextPath("/rest")
                        .bindingMode(RestBindingMode.json)
                        .host("localhost")
                        .port("8080")
                        .dataFormatProperty("prettyPrint", "true");

                // Documentation config
                restConfiguration()
                        .apiContextPath("/docs")
                        .apiProperty("api.title", "Camel REST API")
                        .apiProperty("api.version", "1.0")
                        .apiProperty("cors", "true")
                        .apiContextRouteId("doc-api");

                rest("")
                        .post("/demo")
                        .toD("direct:demo")
                        .consumes(APPLICATION_JSON_VALUE)
                        .produces(APPLICATION_JSON_VALUE)
                        .type(DemoRequest.class)
                        .id("demo-rest-route");

                from("direct:demo")
                        .choice()
                        .when()
                        .simple("${body.subject.type} == 'SubjectA' ")
                        .to("bean:SubjectAService")
                        .otherwise()
                        .to("bean:SubjectBService")
                        .endChoice()
                        .id("demo-direct-route");
            }
        };
    }
}
