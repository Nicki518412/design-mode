package org.suki.design.mode.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.suki.design.mode.context.TextContext;

import java.util.Map;

@Component
@Slf4j
public class TextInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        String token = request.getHeader("text");
        Map<Object, Object> map = Map.of("TEXT", token);
        TextContext.set(map);
        log.info("text设置成功,{}",map);
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        TextContext.remove();
        log.info("text清除成功");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
