package com.wy.ddd.infrastructure.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @Author wangyang
 * @Create 2022/4/25 13:50
 */
@AllArgsConstructor
public enum BaseResponseEnum {
    SUCCESS(200, "成功"),
    FAIL(100, "失败");

    @Getter
    @Setter
    private Integer code;

    @Getter
    @Setter
    private String desc;
}
