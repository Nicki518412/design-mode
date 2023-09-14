package org.suki.design.mode.handler.dynamic;

import org.suki.design.mode.anno.FactoryBeanCreate;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Info;

@FactoryBeanCreate(enumValues = "FACTORY")
public class FactoryInfo implements Info {
    @Override
    public CreateMode getCreateMode() {
        return CreateMode.FACTORY;
    }

    @Override
    public String getInfo(String s) {
        return CreateMode.FACTORY.create(s);
    }
}
