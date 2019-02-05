package com.redmaple.spring.aop.utils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 19:10
 * @Description:
 */
public class ReflectionUtils {

    public static Object invokeMethodUseRelection(Object target, Method method,Object[] args){
        method.setAccessible(true);
        try {
            return method.invoke(target,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

}
