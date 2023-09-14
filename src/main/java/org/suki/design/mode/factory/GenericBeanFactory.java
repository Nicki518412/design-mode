package org.suki.design.mode.factory;

import org.springframework.stereotype.Component;
import org.suki.design.mode.anno.FactoryBeanCreate;
import org.suki.design.mode.current.CurrencyFactoryBean;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@Component
public class GenericBeanFactory<T> {

    public T getInstance(String serviceName,Class<T> cls) throws Exception {
        Map<String, Class<T>> beans = new HashMap<>();
        ServiceLoader<T> loader = ServiceLoader.load(cls);
        loader.stream().forEach(e->{
            String s = e.get().getClass().getAnnotation(FactoryBeanCreate.class).enumValues();
            beans.put(s, (Class<T>) e.get().getClass());
        });
        return (T) new CurrencyFactoryBean<>(beans.get(serviceName)).getObject();
    }

}
