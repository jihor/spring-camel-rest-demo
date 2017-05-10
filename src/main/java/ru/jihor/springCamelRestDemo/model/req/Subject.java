package ru.jihor.springCamelRestDemo.model.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;

import java.io.Serializable;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "type")
@JsonSubTypes({
        @Type(value = SubjectA.class, name = "1"),
        @Type(value = SubjectB.class, name = "2"),
})
public class Subject implements Serializable {
    protected int type;
}
