package com.redmaple.spring.aop.adapter;

import com.redmaple.spring.aop.advisor.Advisor;
import com.redmaple.spring.aop.advisor.BeforeMethodAdvice;
import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;
import com.redmaple.spring.aop.interceptor.BeforeMethodAdviceInterceptor;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 10:10
 * @Description:
 */
public class BeforeMethodAdviceAdapter implements AdviceAdapter {

    public BeforeMethodAdviceAdapter(){}

    public static final BeforeMethodAdviceAdapter INSTANCE = new BeforeMethodAdviceAdapter();

    public static BeforeMethodAdviceAdapter getInstance(){
        return INSTANCE;
    }

    @Override
    public AopMethodInterceptor getInterceptor(Advisor advisor) {
        BeforeMethodAdvice advice = (BeforeMethodAdvice) advisor.getAdvice();
        return new BeforeMethodAdviceInterceptor(advice);
    }
}
