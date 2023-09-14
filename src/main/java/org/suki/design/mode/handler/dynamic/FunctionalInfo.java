package org.suki.design.mode.handler.dynamic;

import org.suki.design.mode.anno.FactoryBeanCreate;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Info;

@FactoryBeanCreate(enumValues = "FUNCTIONAL")
public class FunctionalInfo implements Info {
    @Override
    public CreateMode getCreateMode() {
        return CreateMode.FUNCTIONAL;
    }

    @Override
    public String getInfo(String s) {
        return CreateMode.FUNCTIONAL.create(s);
    }
}
