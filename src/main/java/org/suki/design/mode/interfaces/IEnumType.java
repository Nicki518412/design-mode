package org.suki.design.mode.interfaces;

import com.fasterxml.jackson.annotation.JsonValue;

public interface IEnumType {
    @JsonValue
    int getCode();

    String getName();

    String toString();
}
