package org.suki.design.mode.handler.abstracts;

import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Create;

public abstract class GenericCreate implements Create {
   public abstract CreateMode getCreateMode();

}
