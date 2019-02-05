package com.redmaple.spring.aop.advisor;

import java.lang.reflect.Method;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 16:06
 * @Description:
 */
public interface BeforeMethodAdvice extends Advice {
    void before(Method method,Object[] args,Object target);
}
