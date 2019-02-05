package com.redmaple.spring.aop.core;

import com.fasterxml.jackson.core.type.TypeReference;
import com.redmaple.spring.aop.bean.AopBeanDefinition;
import com.redmaple.spring.bean.BeanDefinition;
import com.redmaple.spring.utils.ClassUtils;
import com.redmaple.spring.utils.JsonUtils;
import org.apache.commons.collections4.CollectionUtils;

import java.io.InputStream;
import java.util.List;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:44
 * @Description:
 */
public class AopApplicationContext extends AopBeanFactory {
    private String fileName;

    public AopApplicationContext(String fileName){
        this.fileName = fileName;
    }

    public void init(){
        loadFile();
    }

    private void loadFile(){
        InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fileName);

        List<AopBeanDefinition> beanDefinitions = JsonUtils.readValue(is, new TypeReference<List<AopBeanDefinition>>() {});
        if (CollectionUtils.isNotEmpty(beanDefinitions)){
            for (AopBeanDefinition beanDefinition : beanDefinitions) {
                Class<?> clz = ClassUtils.loadClass(beanDefinition.getBeanClassName());
                if (clz == ProxyFactoryBean.class){
                    registerBean(beanDefinition.getBeanName(),beanDefinition);
                }else {
                    registerBean(beanDefinition.getBeanName(),(BeanDefinition) beanDefinition);
                }
            }
        }
    }
}
