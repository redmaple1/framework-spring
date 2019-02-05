package com.redmaple.spring.aop.test;

import com.redmaple.spring.aop.advisor.AfterRunningAdvice;

import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 12:04
 * @Description:
 */
public class EndTimeAfterMethod implements AfterRunningAdvice {
    @Override
    public Object after(Object returnVal, Method method, Object[] args, Object target) {
        long endTime = System.currentTimeMillis();
        long startTime = ThreadLocalUtils.get();
        ThreadLocalUtils.remove();
        System.out.println("方法耗时：" + (endTime - startTime) + "ms");
        return returnVal;
    }
}
