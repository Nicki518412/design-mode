package org.suki.design.mode.current;

import lombok.Data;
import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;


/**
 * 通用外部注入Bean
 *
 * @author zhangmeiyang
 * @date 2022/07/07
 */
@Data
public class CurrencyFactoryBean<T> implements FactoryBean<T> {

    private Class<T> clazz;

    public CurrencyFactoryBean(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T getObject() throws Exception {
        return clazz.getDeclaredConstructor().newInstance();
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
