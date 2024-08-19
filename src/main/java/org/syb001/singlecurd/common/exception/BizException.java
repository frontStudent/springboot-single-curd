package org.syb001.singlecurd.common.exception;


import lombok.Data;
import org.syb001.singlecurd.common.enums.ErrorEnum;

@Data
// 插入用户时 用户名重复异常
public class BizException extends RuntimeException {
    private String errorCode;
    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(String errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public BizException(ErrorEnum errorEnum) {
        super(errorEnum.getMessage());
        this.errorCode = errorEnum.getCode();
    }

    public BizException(String message, Throwable cause) {
        super(message, cause);
    }

    public BizException(Throwable cause) {
        super(cause);
    }

    protected BizException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
