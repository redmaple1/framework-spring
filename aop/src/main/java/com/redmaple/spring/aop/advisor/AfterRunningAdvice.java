package com.redmaple.spring.aop.advisor;

import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 16:09
 * @Description:
 */
public interface AfterRunningAdvice extends Advice {
    Object after(Object returnVal,Method method,Object[] args,Object target);
}
