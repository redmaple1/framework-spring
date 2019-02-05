package com.redmaple.spring.aop.core;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:03
 * @Description:
 */
public interface AopProxy {

    Object getProxy();

    Object getProxy(ClassLoader classLoader);

}
