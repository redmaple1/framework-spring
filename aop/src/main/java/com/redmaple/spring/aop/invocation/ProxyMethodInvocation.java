package com.redmaple.spring.aop.invocation;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 15:52
 * @Description:
 */
public interface ProxyMethodInvocation extends MethodInvocation {
    Object getProxy();
}
