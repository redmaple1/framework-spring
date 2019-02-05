package com.redmaple.spring.aop.advisor;

import lombok.Data;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 19:27
 * @Description:
 */
@Data
public class Advisor {

    //干什么
    private Advice advice;
    //在哪里
    private Pointcut pointcut;

}
