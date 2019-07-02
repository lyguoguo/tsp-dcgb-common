package com.ecarx.common.utils;

import com.ecarx.common.bean.ModifyBean;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: create by ggaly
 * @version: v1.0
 * @description: com.ecarx.vehicle.library.utils
 * @date:2019/6/14
 **/
public class DataUtil {

    public static String modifyFieldToStr(Object preObj, Object aftObj, List<String> checkFields){
        if(null == checkFields || checkFields.size() == 0){
            return "";
        }
        Map<String, ModifyBean> changeBeanMap = getModifyFieldMap(preObj,aftObj,checkFields);
        if(null != changeBeanMap && changeBeanMap.size() > 0){
            StringBuffer sb = new StringBuffer();
            sb.append("变更信息：{");
            changeBeanMap.forEach((key,value)->{
                sb.append("【");
                sb.append(key);
                sb.append("】：");
                sb.append(value.getPreVelue());
                sb.append("->");
                sb.append(value.getAftValue());
                sb.append("；");
            });
            sb.append("}");
            return sb.toString();
        }else{
            return null;
        }
    }

    private static Map<String, ModifyBean> getModifyFieldMap(Object preObj, Object aftObj, List<String> checkFields) {
        Map<String, ModifyBean> changeBeanMap = new HashMap<>();
        if(null == preObj || null == aftObj){
            return changeBeanMap;
        }
        Field[] preFields = preObj.getClass().getDeclaredFields();
        Field[] aftFields = aftObj.getClass().getDeclaredFields();
        for(int i=0;i<preFields.length;i++){
            Field f11 = preFields[i];
            f11.setAccessible(true);
            for(int j=0;j<aftFields.length;j++){
                Field f22 = aftFields[j];
                f22.setAccessible(true);
                String fieldName = f11.getName();
                if(checkFields.contains(fieldName)){
                    if(f11.getName().equals(f22.getName())){
                        try {
                            if(null == f11.get(preObj) && null == f22.get(aftObj)){break;}
                            if(null != f11.get(preObj) && null != f22.get(aftObj) && f11.get(preObj).equals(f22.get(aftObj))){break;}
                            ModifyBean changeBean = new ModifyBean(f11.get(preObj),f22.get(aftObj));
                            changeBeanMap.put(f11.getName(),changeBean);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
        return changeBeanMap;
    }


    public static void main(String[] args) {
    }
}
