package com.redmaple.spring.aop.interceptor;

import com.redmaple.spring.aop.advisor.BeforeMethodAdvice;
import com.redmaple.spring.aop.invocation.MethodInvocation;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 16:12
 * @Description:
 */
public class BeforeMethodAdviceInterceptor implements AopMethodInterceptor {

    private BeforeMethodAdvice advice;

    public BeforeMethodAdviceInterceptor(BeforeMethodAdvice advice){
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        advice.before(mi.getMethod(),mi.getArguments(),mi);
        return mi.proceed();
    }
}
