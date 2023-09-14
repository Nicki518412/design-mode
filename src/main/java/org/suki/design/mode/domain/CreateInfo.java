package org.suki.design.mode.domain;

import lombok.Data;
import org.suki.design.mode.enums.CreateMode;

@Data
public class CreateInfo {
    private CreateMode createMode;
    private String info;
}
