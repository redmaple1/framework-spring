package com.redmaple.spring.aop.test;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 12:07
 * @Description:
 */
public class TestService {

    public void testMethod() throws InterruptedException {
        System.out.println("This is a test method");
        Thread.sleep(1000);
    }

}
