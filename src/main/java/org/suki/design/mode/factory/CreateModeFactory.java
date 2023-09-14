package org.suki.design.mode.factory;

import org.springframework.stereotype.Component;
import org.suki.design.mode.current.CurrencyFactoryBean;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.interfaces.Info;

import java.util.HashMap;
import java.util.Map;
import java.util.ServiceLoader;

@Component
public class CreateModeFactory {
    private static final Map<CreateMode, Class<? extends Info>> MAP;

    static {
        try {
            MAP = new HashMap<>();
            ServiceLoader<Info> loader = ServiceLoader.load(Info.class);
            loader.stream().forEach(e->{
                MAP.put(e.get().getCreateMode(), e.get().getClass());
            });
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }


    public Info getInstance(CreateMode createMode) throws Exception {
        return new CurrencyFactoryBean<>(MAP.get(createMode)).getObject();
    }

}
