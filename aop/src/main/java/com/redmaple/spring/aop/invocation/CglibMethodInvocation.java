package com.redmaple.spring.aop.invocation;

import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 19:21
 * @Description:
 */
public class CglibMethodInvocation extends ReflectionMethodInvocation {

    private MethodProxy methodProxy;

    public CglibMethodInvocation(Object proxy, Object target, Method method, Object[] arguments, List<AopMethodInterceptor> interceptorList,MethodProxy methodProxy) {
        super(proxy, target, method, arguments, interceptorList);
        this.methodProxy = methodProxy;
    }

    @Override
    protected Object invokeOrigin() throws Throwable {
        return methodProxy.invoke(target,arguments);
    }
}
