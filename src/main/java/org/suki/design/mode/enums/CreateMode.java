package org.suki.design.mode.enums;

import lombok.Getter;
import org.suki.design.mode.interfaces.Create;
import org.suki.design.mode.interfaces.IEnumType;


@Getter
public enum CreateMode implements Create, IEnumType {
    DIRECT("DIRECT",1){
        public String create(String info) {
            return CreateMode.DIRECT.getName();
        }
    },
    FACTORY("FACTORY",2) {
        public String create(String info) {
            return CreateMode.FACTORY.getName();
        }
    },
    REFLECT("REFLECT",3) {
        public String create(String info) {
            return CreateMode.REFLECT.getName();
        }
    },
    FUNCTIONAL("FUNCTIONAL",4) {
        public String create(String info) {
            return CreateMode.FUNCTIONAL.getName();
        }
    };

    private final String name;
    private final int code;

    CreateMode(String name, int code) {
        this.name = name;
        this.code = code;
    }

    public String toString() {
        return this.name;
    }
}
