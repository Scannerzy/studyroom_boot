package com.zy.common;

public enum CommonExceptionEnum {


    USERNAME_ISNULL(10001, "用户名不能为空"),
    PASSWORD_ISNULL(10002, "密码不能为空"),
    PASSWORD_ERROR(10003, "密码错误"),
    USER_ISNULL(10004, "用户不存在"),

    ;

    private int state;
    private String stateInfo;

    public int getState() {
        return state;
    }

    public String getStateInfo() {
        return stateInfo;
    }


    CommonExceptionEnum(int state, String stateInfo) {
        this.state = state;
        this.stateInfo = stateInfo;
    }

    /**
     * 根据int类型的index,找到对应StateEnum
     *
     * @param index
     * @return
     */
    public static CommonExceptionEnum stateOf(int index) {
        for (CommonExceptionEnum state : values()) {
            if (state.getState() == index) {
                return state;
            }
        }
        return null;
    }

    /**
     * 根据int类型的index,找到对应的String的值
     *
     * @param index
     * @return
     */
    public static String valuesOf(int index) {
        for (CommonExceptionEnum state : values()) {
            if (state.getState() == index) {
                return state.getStateInfo();
            }
        }
        return "null";
    }
}
