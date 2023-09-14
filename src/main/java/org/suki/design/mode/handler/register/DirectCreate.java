package org.suki.design.mode.handler.register;

import org.springframework.stereotype.Component;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.handler.abstracts.GenericCreate;

@Component
public class DirectCreate extends GenericCreate  {
    public CreateMode getCreateMode() {
        return CreateMode.DIRECT;
    }

    public String create(String info) {
        return CreateMode.DIRECT.create(info);
    }
}
