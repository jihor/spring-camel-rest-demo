package ru.jihor.springCamelRestDemo.model.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Data
@ApiModel(description = "SubjectA: a simple person class")
public class SubjectA extends Subject implements Serializable {
    public SubjectA() {
        super();
        setType("SubjectA");
    }

    private String lastName;
    private String firstName;
}
