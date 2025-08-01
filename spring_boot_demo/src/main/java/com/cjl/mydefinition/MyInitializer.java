package com.cjl.mydefinition;

import com.cjl.Test;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class MyInitializer implements ApplicationContextInitializer {
    @Override
    public void initialize(ConfigurableApplicationContext applicationContext) {
//        if (applicationContext instanceof GenericApplicationContext) {
//            GenericApplicationContext genericContext = (GenericApplicationContext) applicationContext;
//            genericContext.registerBean(Test.class);
//            genericContext.refresh();
//        }
    }
}
