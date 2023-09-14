package org.suki.design.mode.handler.dynamic;

import org.suki.design.mode.anno.FactoryBeanCreate;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Info;

@FactoryBeanCreate(enumValues = "REFLECT")
public class ReflectInfo implements Info {
    @Override
    public CreateMode getCreateMode() {
        return CreateMode.REFLECT;
    }

    @Override
    public String getInfo(String s) {
        return CreateMode.REFLECT.create(s);
    }
}
