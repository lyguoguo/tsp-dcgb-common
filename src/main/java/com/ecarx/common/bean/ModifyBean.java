package com.ecarx.common.bean;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.ecarx.vehicle.library.bean
 * @date:2019/6/14
 **/
public class ModifyBean {
    private Object preVelue;
    private Object aftValue;

    public ModifyBean(){

    }

    public ModifyBean(Object preVelue, Object aftValue) {
        this.preVelue = preVelue;
        this.aftValue = aftValue;
    }

    public Object getPreVelue() {
        return preVelue;
    }

    public void setPreVelue(Object preVelue) {
        this.preVelue = preVelue;
    }

    public Object getAftValue() {
        return aftValue;
    }

    public void setAftValue(Object aftValue) {
        this.aftValue = aftValue;
    }
}
