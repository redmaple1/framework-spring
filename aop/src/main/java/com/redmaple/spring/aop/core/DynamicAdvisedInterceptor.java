package com.redmaple.spring.aop.core;

import com.redmaple.spring.aop.advisor.TargetSource;
import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;
import com.redmaple.spring.aop.invocation.CglibMethodInvocation;
import com.redmaple.spring.aop.invocation.MethodInvocation;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:18
 * @Description:
 */
public class DynamicAdvisedInterceptor implements MethodInterceptor {

    private final List<AopMethodInterceptor> interceptorList;

    private final TargetSource targetSource;

    public DynamicAdvisedInterceptor(List<AopMethodInterceptor> interceptorList,TargetSource targetSource){
        this.interceptorList = interceptorList;
        this.targetSource = targetSource;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        MethodInvocation invocation = new CglibMethodInvocation(o,targetSource.getTargetObject(),method,args,interceptorList,methodProxy);
        return invocation.proceed();
    }
}
