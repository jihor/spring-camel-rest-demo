//package ru.jihor.springCamelRestDemo.routing;
//
//import ru.jihor.springCamelRestDemo.model.req.DemoRequest;
//import org.apache.camel.builder.RouteBuilder;
//import org.apache.camel.model.rest.RestBindingMode;
//import org.springframework.stereotype.Component;
//
//import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
//
///**
// * @author jihor (jihor@ya.ru)
// *         Created on 2017-05-10
// */
//@Component
//public class SubjectRouter extends RouteBuilder{
//
//    @Override
//    public void configure() throws Exception {
//        // Demo config can be seen at
//        // https://github.com/apache/camel/blob/master/examples/camel-example-swagger-cdi/src/main/java/org/apache/camel/example/cdi/UserRouteBuilder.java
//        restConfiguration()
//                .contextPath("/rest")
//                .apiContextPath("/docs")
//                .apiProperty("api.title", "Camel REST API")
//                .apiProperty("api.version", "1.0")
//                .apiProperty("cors", "true")
//                .apiContextRouteId("doc-api")
//                .bindingMode(RestBindingMode.json);
//
//        rest("/")
//                .post("/demo")
//                .toD("direct:demo")
//                .consumes(APPLICATION_JSON_VALUE)
//                .produces(APPLICATION_JSON_VALUE)
//                .type(DemoRequest.class)
//                .id("demo-rest-route");
//
//        from("direct:demo")
//                .choice()
//                .when()
//                    .simple("${body.subject.type} == 'SubjectA' ")
//                    .to("bean:SubjectAService")
//                .otherwise()
//                    .to("bean:SubjectBService")
//                .endChoice()
//                .id("demo-direct-route");
//    }
//}