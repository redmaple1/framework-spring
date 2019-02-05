package com.redmaple.spring.aop.test;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 12:01
 * @Description:
 */
public class ThreadLocalUtils {

    private static ThreadLocal<Long> threadLocal = new ThreadLocal<Long>();

    public static long get(){
        if (threadLocal == null){
            throw new IllegalStateException("ThreadLocal");
        }
        return threadLocal.get();
    }

    public static void set(long startTime){
        threadLocal.set(startTime);
    }

    public static void remove(){
        threadLocal.remove();
    }

}
