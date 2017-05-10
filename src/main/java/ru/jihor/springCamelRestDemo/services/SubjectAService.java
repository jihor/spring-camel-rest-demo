package ru.jihor.springCamelRestDemo.services;

import ru.jihor.springCamelRestDemo.model.req.DemoRequest;
import ru.jihor.springCamelRestDemo.model.resp.DemoResponse;
import ru.jihor.springCamelRestDemo.model.req.SubjectA;
import org.springframework.stereotype.Service;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Service("SubjectAService")
public class SubjectAService {

    public DemoResponse greet(DemoRequest envelope){
        return new DemoResponse("I am Service A. Your type is " +
                envelope.getSubject().getType() +
                ", last name is " +
                ((SubjectA)envelope.getSubject()).getLastName());
    }
}
