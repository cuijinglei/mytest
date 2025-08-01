package com.cjl.service;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional(propagation = Propagation.REQUIRED)
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
//@EnableAspectJAutoProxy(proxyTargetClass=true)
public class UserServiceImpl implements UserService  {
   // @Override
    public void a() {
        System.out.println("aaaaaa");
    }

   // @Override
    public void b() {
        System.out.println("bbbbbbb");
    }

    public void c(){
        System.out.println("cccccccccc");
    }
}
