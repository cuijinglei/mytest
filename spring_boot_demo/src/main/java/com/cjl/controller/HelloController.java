package com.cjl.controller;

import com.cjl.Test;
import com.cjl.service.OrderService;
import com.cjl.service.UserService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("hello")
public class HelloController implements ApplicationContextAware {
    private Log logger = LogFactory.getLog(HelloController.class);
    @Autowired
    private UserService userServiceImpl;
    @Autowired
    private OrderService orderServiceImpl;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private DataSource dataSource;
    @Autowired
    ConfigurableApplicationContext context1;
    @Autowired
    ConfigurableListableBeanFactory factory;


    private ApplicationContext context;

    //@Scheduled(fixedRate = 1000)
    public void demo() {
        ConcurrentHashMap<String, Object> map = new ConcurrentHashMap<>();
        map.put("", "");

        System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
        userServiceImpl.b();
    }

    @RequestMapping("test")
    public String test() {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from student");
        logger.info("结果条数:" + maps.size());
        return new Date() + "";
    }

    @RequestMapping("print")
    public String print() {

        logger.info("print:" + new Date());
        return "现在时间:" + new Date();
    }

    @RequestMapping("registry")
    public String registry() {
        ConfigurableListableBeanFactory beanFactory = context1.getBeanFactory();
        ((BeanDefinitionRegistry)context).registerBeanDefinition("qqq",new RootBeanDefinition(Test.class));
        ((GenericApplicationContext)context1).registerBean("ccc", Test.class);
        ((GenericApplicationContext)context1).registerBean(Test.class,()->new Test());
        logger.info("print:" + new Date());
        return "现在时间:" + new Date();
    }

        @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
            applicationContext.getEnvironment().getProperty("");
    }
}
