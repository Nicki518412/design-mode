package org.suki.design.mode.handler.dynamic;

import org.suki.design.mode.anno.FactoryBeanCreate;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Info;

@FactoryBeanCreate(enumValues = "DIRECT")
public class DirectInfo implements Info {
    @Override
    public CreateMode getCreateMode() {
        return CreateMode.DIRECT;
    }

    @Override
    public String getInfo(String s) {
        return CreateMode.DIRECT.create(s);
    }
}
