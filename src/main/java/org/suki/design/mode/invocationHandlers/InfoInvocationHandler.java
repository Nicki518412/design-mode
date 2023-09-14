package org.suki.design.mode.invocationHandlers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.suki.design.mode.interfaces.Info;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InfoInvocationHandler implements InvocationHandler {

    private Class<? extends Info> info;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Info obj = info.getDeclaredConstructor().newInstance();
        return method.invoke(obj,args);
    }
}
