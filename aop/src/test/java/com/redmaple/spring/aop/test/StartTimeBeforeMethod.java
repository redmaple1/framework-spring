package com.redmaple.spring.aop.test;

import com.redmaple.spring.aop.advisor.BeforeMethodAdvice;

import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:59
 * @Description:
 */
public class StartTimeBeforeMethod implements BeforeMethodAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) {
        long startTime = System.currentTimeMillis();
        System.out.println("开始计时");
        ThreadLocalUtils.set(startTime);
    }
}
