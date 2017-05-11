package ru.jihor.springCamelRestDemo.model.req;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
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
        @Type(value = SubjectA.class, name = "SubjectA"),
        @Type(value = SubjectB.class, name = "Subject"),
})
@ApiModel(description = "Subject, can be of type A (SubjectA class) or type B (SubjectB class)", subTypes = {SubjectA.class, SubjectB.class}, discriminator = "type")
public class Subject implements Serializable {
    @ApiModelProperty(allowableValues = "SubjectA, SubjectB", required = true, value = "Property defining the subject type")
    protected String type;
}
