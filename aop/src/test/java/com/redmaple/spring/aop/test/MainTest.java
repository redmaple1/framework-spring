package com.redmaple.spring.aop.test;

import com.redmaple.spring.aop.core.AopApplicationContext;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 12:11
 * @Description:
 */
public class MainTest {
    public static void main(String[] args) throws Exception {
        AopApplicationContext aopApplicationContext = new AopApplicationContext("application.json");
        aopApplicationContext.init();
        TestService testService = (TestService) aopApplicationContext.getBean("testServiceProxy");
        testService.testMethod();
    }
}
