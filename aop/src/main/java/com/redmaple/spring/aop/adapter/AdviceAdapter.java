package com.redmaple.spring.aop.adapter;

import com.redmaple.spring.aop.advisor.Advisor;
import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 10:06
 * @Description:
 */
public interface AdviceAdapter {

    AopMethodInterceptor getInterceptor(Advisor advisor);

}
