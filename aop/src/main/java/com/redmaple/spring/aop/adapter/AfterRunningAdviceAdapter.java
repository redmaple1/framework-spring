package com.redmaple.spring.aop.adapter;

import com.redmaple.spring.aop.advisor.Advisor;
import com.redmaple.spring.aop.advisor.AfterRunningAdvice;
import com.redmaple.spring.aop.interceptor.AfterRunningAdviceInterceptor;
import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 10:19
 * @Description:
 */
public class AfterRunningAdviceAdapter implements AdviceAdapter {

    public AfterRunningAdviceAdapter(){}

    public static final AfterRunningAdviceAdapter INSTANCE = new AfterRunningAdviceAdapter();

    public static AfterRunningAdviceAdapter getInstance(){
        return INSTANCE;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        AfterRunningAdvice advice = (AfterRunningAdvice) advisor.getAdvice();
        return new AfterRunningAdviceInterceptor(advice);
    }
}
