package org.suki.design.mode.context;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;
import org.suki.design.mode.enums.CreateMode;
import org.suki.design.mode.handler.abstracts.GenericCreate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

@Component
@Slf4j
public class GenericContext implements InitializingBean, DisposableBean {

    public static Map<CreateMode, Function<String, String>> HANDLER_MAP = new HashMap<>();
    public static Map<CreateMode, GenericCreate> HANDLER_COMPONENT_MAP = new HashMap<>();

    @Resource
    private List<GenericCreate> genericCreateList;


    public void destroy() {

    }

    public void afterPropertiesSet() {
        log.info("context initializing bean");
        initializeCreateBean(genericCreateList);
    }

    private void initializeCreateBean(List<GenericCreate> genericCreateList) {
        genericCreateList.forEach( e->{
            HANDLER_MAP.put(e.getCreateMode(), e::create);
            HANDLER_COMPONENT_MAP.put(e.getCreateMode(),e);
        });
    }
}
