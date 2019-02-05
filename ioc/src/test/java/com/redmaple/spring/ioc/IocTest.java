package com.redmaple.spring.ioc;

import com.redmaple.spring.core.SimpleJsonApplicationContext;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 16:20
 * @Description:
 */
public class IocTest {
    public static void main(String[] args) throws Exception {
        SimpleJsonApplicationContext applicationContext = new SimpleJsonApplicationContext("application.json");
        applicationContext.init();
        Dancer dancer = (Dancer) applicationContext.getBean("dancer");
        dancer.dance();
    }
}
