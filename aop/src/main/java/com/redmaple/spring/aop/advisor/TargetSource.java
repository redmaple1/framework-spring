package com.redmaple.spring.aop.advisor;

import lombok.Data;

/**
 * @Author: renmagical
 * @Date: 2019-02-04 19:28
 * @Description:
 */
@Data
public class TargetSource {

    private Class<?> targetClass;

    private Object targetObject;

}
