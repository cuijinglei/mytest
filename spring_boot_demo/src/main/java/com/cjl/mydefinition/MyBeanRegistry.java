package com.cjl.mydefinition;

import com.cjl.Test;
import com.cjl.YunSuan;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.*;

public class MyBeanRegistry implements BeanDefinitionRegistryPostProcessor {
    @Override
    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) {
        // 手动注册BeanDefinition（此时容器还未实例化任何Bean）
//        RootBeanDefinition beanDefinition = new RootBeanDefinition(Test.class);
//        registry.registerBeanDefinition("myCustomBean", beanDefinition);

        AbstractBeanDefinition beanDefinition = BeanDefinitionBuilder.genericBeanDefinition().getBeanDefinition();
        beanDefinition.setBeanClass(Test.class);
        //registry.registerBeanDefinition("user", beanDefinition);

    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) {
        // 可选的后续处理
        //beanFactory.registerSingleton("abc",new YunSuan());
    }
}

