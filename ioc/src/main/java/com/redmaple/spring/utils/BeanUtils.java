package com.redmaple.spring.utils;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 14:38
 * @Description: 负责处理对象的实例化
 */
public class BeanUtils {

    /**
     * 通过Cglib实例化对象
     * @param clz
     * @param ctr
     * @param args
     * @param <T>
     * @return
     */
    public static <T> T instanceByCglib(Class<T> clz, Constructor ctr,Object[] args){
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clz);
        enhancer.setCallback(NoOp.INSTANCE);
        if (ctr == null){
            return (T)enhancer.create();
        }else {
            return (T)enhancer.create(ctr.getParameterTypes(),args);
        }
    }
}
