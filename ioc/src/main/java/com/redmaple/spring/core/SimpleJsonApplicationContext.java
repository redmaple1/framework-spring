package com.redmaple.spring.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.redmaple.spring.bean.BeanDefinition;
import com.redmaple.spring.utils.JsonUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 16:00
 * @Description:
 */
public class SimpleJsonApplicationContext extends SimpleBeanFactory {

    private String fileName;

    public SimpleJsonApplicationContext(String fileName){
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<BeanDefinition> beanDefinitions = JsonUtils.readValue(is,new TypeReference<List<BeanDefinition>>(){});

        if (CollectionUtils.isNotEmpty(beanDefinitions)){
            for (BeanDefinition beanDefinition : beanDefinitions) {
                registerBean(beanDefinition.getBeanName(),beanDefinition);
            }
        }
    }
}
