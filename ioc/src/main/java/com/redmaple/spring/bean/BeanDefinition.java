package com.redmaple.spring.bean;

import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class BeanDefinition {

    private String beanName;

    private String beanClassName;

    private String beanInterfaceName;

    private List<ConstructorArg> constructorArgs;

    private List<PropertyArg> propertyArgs;
}
