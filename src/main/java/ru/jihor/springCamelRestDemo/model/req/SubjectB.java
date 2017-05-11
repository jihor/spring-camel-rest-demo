package ru.jihor.springCamelRestDemo.model.req;

import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Data
@ApiModel(description = "SubjectB: an entrepreneur class")
public class SubjectB extends Subject implements Serializable {
    private String inn;

    public SubjectB() {
        super();
        setType("SubjectB");
    }
}
