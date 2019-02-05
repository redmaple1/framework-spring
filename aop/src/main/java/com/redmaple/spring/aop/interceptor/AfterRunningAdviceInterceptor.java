package com.redmaple.spring.aop.interceptor;

import com.redmaple.spring.aop.advisor.AfterRunningAdvice;
import com.redmaple.spring.aop.invocation.MethodInvocation;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 18:37
 * @Description:
 */
public class AfterRunningAdviceInterceptor implements AopMethodInterceptor {

    private AfterRunningAdvice advice;

    public AfterRunningAdviceInterceptor(AfterRunningAdvice advice){
        this.advice = advice;
    }

    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        Object returnVal = mi.proceed();
        advice.after(returnVal,mi.getMethod(),mi.getArguments(),mi);
        return returnVal;
    }
}
