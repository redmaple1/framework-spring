package com.redmaple.spring.aop.invocation;

import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;
import com.redmaple.spring.aop.utils.ReflectionUtils;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 18:55
 * @Description:
 */
public class ReflectionMethodInvocation implements ProxyMethodInvocation {

    protected final Object proxy;

    protected final Object target;

    protected final Method method;

    protected Object[] arguments = new Object[0];

    //存储所有的拦截器
    protected final List<AopMethodInterceptor> interceptorList;

    private int currentInterceptorIndex = -1;

    public ReflectionMethodInvocation(Object proxy,Object target,Method method,Object[] arguments,List<AopMethodInterceptor> interceptorList){
        this.proxy = proxy;
        this.target = target;
        this.method = method;
        this.arguments = arguments;
        this.interceptorList = interceptorList;
    }

    @Override
    public Object getProxy() {
        return proxy;
    }

    @Override
    public Method getMethod() {
        return method;
    }

    @Override
    public Object[] getArguments() {
        return arguments;
    }

    @Override
    public Object proceed() throws Throwable {
        //执行完所有的拦截器方法后，执行目标方法
        if (currentInterceptorIndex == interceptorList.size() - 1){
            return invokeOrigin();
        }

        //迭代地执行拦截器。我们实现的拦截器都会执行 mi.proceed()，实际上又会执行这个方法，实现了一个递归的调用，直到执行完所有的拦截器
        AopMethodInterceptor interceptor = interceptorList.get(++currentInterceptorIndex);
        return interceptor.invoke(this);
    }

    protected Object invokeOrigin() throws Throwable{
        return ReflectionUtils.invokeMethodUseRelection(target,method,arguments);
    }
}
