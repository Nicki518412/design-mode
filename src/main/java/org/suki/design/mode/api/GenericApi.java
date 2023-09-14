package org.suki.design.mode.api;

import jakarta.annotation.Resource;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;
import org.suki.design.mode.context.GenericContext;
import org.suki.design.mode.domain.CreateInfo;
import org.suki.design.mode.factory.CreateModeFactory;
import org.suki.design.mode.factory.CreateModeInterfaceFactory;
import org.suki.design.mode.factory.GenericBeanFactory;
import org.suki.design.mode.handler.dynamic.DirectInfo;
import org.suki.design.mode.interfaces.Info;

@RestController
@RequestMapping("api")
public class GenericApi {

    @Resource
    private CreateModeFactory createModeFactory;

    @Resource
    private CreateModeInterfaceFactory createModeInterfaceFactory;

    @Resource
    private GenericBeanFactory<Info> genericBeanFactory;

    @Resource
    private ApplicationContext applicationContext;

    /**策略模式1
     * @param createInfo
     * @return {@link Object}
     */
    @GetMapping("createString")
    public Object createString(@RequestBody CreateInfo createInfo) {
        return GenericContext.HANDLER_MAP.get(createInfo.getCreateMode()).apply(createInfo.getInfo());
    }

    /**策略模式2
     * @param createInfo
     * @return {@link Object}
     */
    @GetMapping("createStringComponent")
    public Object createStringComponent(@RequestBody CreateInfo createInfo) {
        applicationContext.getBean(Info.class);
        return GenericContext.HANDLER_COMPONENT_MAP.get(createInfo.getCreateMode()).create(createInfo.getInfo());
    }

    /**动态工厂bean
     * @param createInfo
     * @return {@link Object}
     * @throws Exception
     */
    @GetMapping("createStringFactory")
    public Object createStringFactory(@RequestBody CreateInfo createInfo) throws Exception {
        return createModeFactory.getInstance(createInfo.getCreateMode()).getInfo(createInfo.getInfo());
    }

    /**动态工厂bean
     * @param createInfo
     * @return {@link Object}
     * @throws Exception
     */
    @GetMapping("createStringInterfaceFactory")
    public Object createStringInterfaceFactory(@RequestBody CreateInfo createInfo) throws Exception {
        return createModeInterfaceFactory.getInstance(createInfo.getCreateMode()).getInfo(createInfo.getInfo());
    }

    /**动态工厂bean
     * @param createInfo
     * @return {@link Object}
     * @throws Exception
     */
    @GetMapping("createStringGenericBeanFactory")
    public Object createStringGenericBeanFactory(@RequestBody CreateInfo createInfo) throws Exception {
       return genericBeanFactory.getInstance(createInfo.getCreateMode().getName(),Info.class).getInfo(createInfo.getInfo());
    }

}
