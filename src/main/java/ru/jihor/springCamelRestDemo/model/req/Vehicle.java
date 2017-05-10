package ru.jihor.springCamelRestDemo.model.req;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */

@Data
public class Vehicle implements Serializable {
    private String vin;
}
