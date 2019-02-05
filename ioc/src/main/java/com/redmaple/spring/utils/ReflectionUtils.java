package com.redmaple.spring.utils;

import java.lang.reflect.Field;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 14:59
 * @Description: 通过Java的反射原理，完成对象的依赖注入
 */
public class ReflectionUtils {

    public static void injectField(Field field,Object obj,Object value) throws IllegalAccessException {
        if (field != null){
            field.setAccessible(true);
            field.set(obj, value);
        }
    }
}
