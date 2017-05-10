package ru.jihor.springCamelRestDemo.services;

import ru.jihor.springCamelRestDemo.model.resp.DemoResponse;
import ru.jihor.springCamelRestDemo.model.req.DemoRequest;
import ru.jihor.springCamelRestDemo.model.req.SubjectB;
import org.springframework.stereotype.Service;

/**
 * @author jihor (jihor@ya.ru)
 *         Created on 2017-05-10
 */
@Service("SubjectBService")
public class SubjectBService {

    public DemoResponse greet(DemoRequest envelope){
        return new DemoResponse("I am Service B. Your type is " +
                envelope.getSubject().getType() +
                ", inn is " +
                ((SubjectB)envelope.getSubject()).getInn());
    }
}
