package com.redmaple.spring.aop.invocation;

import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 15:50
 * @Description:
 */
public interface MethodInvocation {
    Method getMethod();

    Object[] getArguments();

    Object proceed() throws Throwable;
}
