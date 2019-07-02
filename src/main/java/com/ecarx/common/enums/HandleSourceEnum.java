package com.ecarx.common.enums;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.ecarx.vehicle.library.common.enums
 * @date:2019/6/27
 **/
public enum HandleSourceEnum {
    BINLOG_SYNC(1,"binlog同步"),
    BACKEND_MODIFY(2,"backend更新")
    ;

    private Integer code;
    private String desc;

    HandleSourceEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
