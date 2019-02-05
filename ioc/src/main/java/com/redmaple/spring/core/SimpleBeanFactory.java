package com.redmaple.spring.core;

import com.redmaple.spring.bean.BeanDefinition;
import com.redmaple.spring.bean.ConstructorArg;
import com.redmaple.spring.utils.BeanUtils;
import com.redmaple.spring.utils.ClassUtils;
import com.redmaple.spring.utils.ReflectionUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: renmagical
 * @Date: 2019-01-22 15:15
 * @Description:
 */
public class SimpleBeanFactory implements BeanFactory {

    private static final ConcurrentHashMap<String,Object> beanMap = new ConcurrentHashMap<>();

    private static final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();

    private static final Set<String> beanNameSet = Collections.synchronizedSet(new HashSet<>());

    @Override
    public Object getBean(String name) throws Exception {
        //若对象已经实例化过，直接返回
        Object bean = beanMap.get(name);
        if (bean != null){
            return bean;
        }

        //若没有实例化过，调用createBean来创建对象
        bean = createBean(beanDefinitionMap.get(name));

        if (bean != null){
            //创建成功后，注入对象需要的参数
            populateBean(bean);

            //将对象放入map中，以便后续使用
            beanMap.put(name,bean);
        }
        return bean;
    }

    protected void registerBean(String name,BeanDefinition beanDefinition){
        beanDefinitionMap.put(name,beanDefinition);
        beanNameSet.add(name);
    }

    private Object createBean(BeanDefinition beanDefinition) throws Exception {
        String beanClassName = beanDefinition.getBeanClassName();
        Class clz = ClassUtils.loadClass(beanClassName);
        if (clz == null){
            throw new Exception("Can not find bean by bean name");
        }

        List<ConstructorArg> constructorArgs = beanDefinition.getConstructorArgs();
        if (CollectionUtils.isNotEmpty(constructorArgs)){
            List<Object> objects = new ArrayList<>();
            for (ConstructorArg constructorArg : constructorArgs) {
                objects.add(getBean(constructorArg.getRef()));
            }
            return BeanUtils.instanceByCglib(clz,clz.getConstructor(),objects.toArray());
        }else {
            return BeanUtils.instanceByCglib(clz,null,null);
        }
    }

    private void populateBean(Object bean) throws Exception {
        Field[] fields = bean.getClass().getSuperclass().getDeclaredFields();
        if (fields != null && fields.length > 0){
            for (Field field : fields) {
                String beanName = field.getName();
                beanName = StringUtils.uncapitalize(beanName);
                if (beanNameSet.contains(field.getName())){
                    Object fieldBean = getBean(beanName);
                    if (fieldBean != null){
                        ReflectionUtils.injectField(field,bean,fieldBean);
                    }
                }
            }
        }
    }
}
