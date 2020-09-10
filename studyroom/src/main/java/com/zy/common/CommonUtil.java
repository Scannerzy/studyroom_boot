package com.zy.common;

public class CommonUtil {
    public static void cast(CommonExceptionEnum commonExceptionEnum){
        throw new CommonException(commonExceptionEnum);
    }

}
