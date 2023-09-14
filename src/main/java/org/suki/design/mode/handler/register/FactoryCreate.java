package org.suki.design.mode.handler.register;

import org.springframework.stereotype.Component;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.handler.abstracts.GenericCreate;

@Component
public class FactoryCreate extends GenericCreate  {
    public CreateMode getCreateMode() {
        return CreateMode.FACTORY;
    }

    public String create(String info) {
        return CreateMode.FACTORY.create(info);
    }
}
