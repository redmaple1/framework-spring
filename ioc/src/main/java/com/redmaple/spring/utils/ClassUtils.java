package com.redmaple.spring.utils;

public class ClassUtils {

    public static ClassLoader getDefaultClassLoader(){
        return Thread.currentThread().getContextClassLoader();
    }

    /**
     * 根据类的名称加载类
     * @param name
     * @return
     */
    public static Class loadClass(String name){
        try {
            return getDefaultClassLoader().loadClass(name);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
