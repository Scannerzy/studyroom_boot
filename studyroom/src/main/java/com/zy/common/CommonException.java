package com.zy.common;


import lombok.Getter;

@Getter
public class CommonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private Integer code;

    /**
     * 消息.
     * @param message
     */
    public CommonException(final String message) {
        super(message);
    }

    /**
     * 自定义相应码.
     * @param cause
     */
    public CommonException(final Throwable cause) {
        super(cause);
    }

    /**
     * 两个都有.
     * @param message
     * @param cause
     */
    public CommonException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public CommonException(final CommonExceptionEnum errorType) {
        super(errorType.getStateInfo());
        code = errorType.getState();
    }
}
