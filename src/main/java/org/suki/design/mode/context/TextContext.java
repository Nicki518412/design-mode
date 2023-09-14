package org.suki.design.mode.context;

import java.util.HashMap;
import java.util.Map;

public class TextContext {

    private static ThreadLocal<Map<Object, Object>> TEXT_CONTEXT = new ThreadLocal<>();

    public static void set(Map<Object, Object> info) {
        Map<Object, Object> map = TEXT_CONTEXT.get();
        if (map == null) {
            map = info;
            TEXT_CONTEXT.set(map);
        }
    }

    public static Map<Object, Object> get() {
        return TEXT_CONTEXT.get();
    }

    public static void remove() {
        TEXT_CONTEXT.remove();
    }

}
