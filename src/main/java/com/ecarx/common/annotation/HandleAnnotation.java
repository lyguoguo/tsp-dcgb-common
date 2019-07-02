package com.ecarx.common.annotation;

import java.lang.annotation.*;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.ecarx.vehicle.library.annotation
 * @date:2019/6/17
 **/
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface HandleAnnotation {
    public enum BUSI_TYPE {vehicle_series, vehicle_default, vehicle_info, vehicle_terminal, vehicle_terminal_config}
    public enum HANDLE_TYPE {UNKNOWN, INSERT, UPDATE, DELETE, SELECT, FLUSH;}

    BUSI_TYPE busiType();
    HANDLE_TYPE handleType();

}
