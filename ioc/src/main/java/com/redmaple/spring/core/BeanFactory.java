package com.redmaple.spring.core;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 15:14
 * @Description:
 */
public interface BeanFactory {
    Object getBean(String name) throws Exception;
}
