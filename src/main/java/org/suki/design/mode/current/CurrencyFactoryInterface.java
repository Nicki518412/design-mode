package org.suki.design.mode.current;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;


/**
 * 通用外部注入Bean
 *
 * @author zhangmeiyang
 * @date 2022/07/07
 */
@Data
public class CurrencyFactoryInterface<T> implements FactoryBean<T> {

    private Class<T> clazz;
    private InvocationHandler invocationHandler;

    public CurrencyFactoryInterface(Class<T> clazz, InvocationHandler invocationHandler) {
        this.clazz = clazz;
        this.invocationHandler = invocationHandler;
    }

    @Override
    public T getObject() {
        return (T) Proxy.newProxyInstance(this.getClass().getClassLoader(), clazz.getInterfaces(), invocationHandler);
    }

    @Override
    public Class<?> getObjectType() {
        return clazz;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
