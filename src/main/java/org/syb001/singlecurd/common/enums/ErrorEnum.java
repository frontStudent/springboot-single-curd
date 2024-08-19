package org.syb001.singlecurd.common.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    USER_DUPLICATE("USER_DUPLICATE", "用户名已被占用"),
    USER_NOT_FOUND("USER_NOT_FOUND", "用户不存在");

    // 获取错误码
    private final String code;
    // 获取错误消息
    private final String message;

    // 枚举的构造函数
    ErrorEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }
}
