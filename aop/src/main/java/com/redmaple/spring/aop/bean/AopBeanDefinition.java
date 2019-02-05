package com.redmaple.spring.aop.bean;

import com.redmaple.spring.bean.BeanDefinition;
import lombok.Data;

import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:24
 * @Description:
 */
@Data
public class AopBeanDefinition extends BeanDefinition {

    private String target;

    private List<String> interceptorNames;

}
