package com.redmaple.spring.ioc;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 16:16
 * @Description:
 */
public class Dancer {
    private Arm arm;
    private Leg leg;

    public void dance(){
        arm.wave();
        leg.jump();
        System.out.println("跳起舞来");
    }
}
