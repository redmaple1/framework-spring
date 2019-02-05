package com.redmaple.spring.aop.interceptor;

import com.redmaple.spring.aop.invocation.MethodInvocation;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 15:55
 * @Description: 方法的拦截器
 */
public interface AopMethodInterceptor {
    Object invoke(MethodInvocation mi) throws Throwable;
}
