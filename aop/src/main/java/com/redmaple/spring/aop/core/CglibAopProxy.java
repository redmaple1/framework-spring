package com.redmaple.spring.aop.core;

import com.redmaple.spring.aop.advisor.AdvisedSupport;
import com.redmaple.spring.utils.ClassUtils;
import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;
import org.apache.commons.collections4.CollectionUtils;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:04
 * @Description:
 */
public class CglibAopProxy implements AopProxy {

    private AdvisedSupport advised;

    private Object[] contructorArgs;

    private Class<?>[] constructorArgtypes;

    public CglibAopProxy(AdvisedSupport config){
        this.advised = config;
    }

    public Object getProxy() {
        return getProxy(null);
    }

    public Object getProxy(ClassLoader classLoader) {
        Class<?> rootClass = advised.getTargetSource().getTargetClass();
        if (classLoader == null){
            classLoader = ClassUtils.getDefaultClassLoader();
        }
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(rootClass.getSuperclass());
        //增加拦截器的核心方法
        Callback callback = getCallBack(advised);
        enhancer.setCallback(callback);
        enhancer.setClassLoader(classLoader);
        if (contructorArgs != null && contructorArgs.length > 0){
            return enhancer.create(constructorArgtypes,contructorArgs);
        }
        return enhancer.create();
    }

    private Callback getCallBack(AdvisedSupport advised){
        return new DynamicAdvisedInterceptor(advised.getList(),advised.getTargetSource());
    }
}
