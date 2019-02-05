package com.redmaple.spring.aop.core;

import com.redmaple.spring.aop.adapter.AfterRunningAdviceAdapter;
import com.redmaple.spring.aop.adapter.BeforeMethodAdviceAdapter;
import com.redmaple.spring.aop.advisor.*;
import com.redmaple.spring.aop.bean.AopBeanDefinition;
import com.redmaple.spring.aop.interceptor.AopMethodInterceptor;
import com.redmaple.spring.core.SimpleBeanFactory;
import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: renmagical
 * @Date: 2019-02-05 11:26
 * @Description:
 */
public class AopBeanFactory extends SimpleBeanFactory {
    private static final ConcurrentHashMap<String, AopBeanDefinition> aopBeanDefinitionMap = new ConcurrentHashMap<String, AopBeanDefinition>();

    private static final ConcurrentHashMap<String,Object> aopBeanMap = new ConcurrentHashMap<String, Object>();

    @Override
    public Object getBean(String name) throws Exception {
        Object aopBean = aopBeanMap.get(name);
        if (aopBean != null){
            return aopBean;
        }
        if (aopBeanDefinitionMap.containsKey(name)){
            AopBeanDefinition aopBeanDefinition = aopBeanDefinitionMap.get(name);
            AdvisedSupport advisedSupport = getAdvisedSupport(aopBeanDefinition);
            aopBean = new CglibAopProxy(advisedSupport).getProxy();
            aopBeanMap.put(name,aopBean);
            return aopBean;
        }
        return super.getBean(name);
    }

    public void registerBean(String name,AopBeanDefinition aopBeanDefinition){
        aopBeanDefinitionMap.put(name,aopBeanDefinition);
    }

    private AdvisedSupport getAdvisedSupport(AopBeanDefinition aopBeanDefinition) throws Exception {
        AdvisedSupport advisedSupport = new AdvisedSupport();
        List<String> interceptorNames = aopBeanDefinition.getInterceptorNames();
        if (CollectionUtils.isNotEmpty(interceptorNames)){
            for (String interceptorName : interceptorNames) {
                Advice advice = (Advice) getBean(interceptorName);

                Advisor advisor = new Advisor();
                advisor.setAdvice(advice);

                if (advice instanceof BeforeMethodAdvice){
                    AopMethodInterceptor interceptor = BeforeMethodAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }

                if (advice instanceof AfterRunningAdvice){
                    AopMethodInterceptor interceptor = AfterRunningAdviceAdapter.getInstance().getInterceptor(advisor);
                    advisedSupport.addAopMethodInterceptor(interceptor);
                }
            }
        }

        TargetSource targetSource = new TargetSource();
        Object object = getBean(aopBeanDefinition.getTarget());
        targetSource.setTargetClass(object.getClass());
        targetSource.setTargetObject(object);
        advisedSupport.setTargetSource(targetSource);
        return advisedSupport;
    }
}
