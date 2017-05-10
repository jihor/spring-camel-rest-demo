package ru.jihor.springCamelRestDemo;

import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import ru.jihor.springCamelRestDemo.model.req.DemoRequest;
import ru.jihor.springCamelRestDemo.model.req.SubjectA;
import ru.jihor.springCamelRestDemo.model.req.SubjectB;
import ru.jihor.springCamelRestDemo.model.req.Vehicle;

import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Slf4j
public class DemoApplicationTests {

    @Value("${local.server.port}")
    private String localServerPort;

    @Test
    public void contextLoads() {
    }

    private static SubjectA subjectA;
    private static SubjectB subjectB;
    private static Vehicle vehicle;

    @BeforeClass
    public static void init() {
        subjectA = new SubjectA();
        subjectA.setFirstName("George");
        subjectA.setLastName("Patton");

        subjectB = new SubjectB();
        subjectB.setInn("304");

        vehicle = new Vehicle();
        vehicle.setVin("792");
    }

    @Test
    public void demoServiceA() {

        given()
            .body(new DemoRequest(subjectA, vehicle))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
        .when()
            .post("http://127.0.0.1:" + localServerPort + "/rest-api/demo")
        .then()
            .statusCode(200)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body("message", equalTo("I am Service A. Your type is 1, last name is Patton"));
    }

    @Test
    public void demoServiceB() {
        given()
            .body(new DemoRequest(subjectB, vehicle))
            .contentType(MediaType.APPLICATION_JSON_VALUE)
        .when()
            .post("http://127.0.0.1:" + localServerPort + "/rest-api/demo")
        .then()
            .statusCode(200)
            .contentType(MediaType.APPLICATION_JSON_VALUE)
            .body("message", equalTo("I am Service B. Your type is 2, inn is 304"));
    }

}
