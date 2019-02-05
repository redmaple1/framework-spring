package com.redmaple.spring.bean;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class ConstructorArg {

    private int index;

    private String name;

    private Object value;

    private String ref;
}
