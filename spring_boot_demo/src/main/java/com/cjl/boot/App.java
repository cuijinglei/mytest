package com.cjl.boot;

import com.cjl.mydefinition.MyInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.cjl"})
@EnableScheduling
public class App {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(App.class);
        //springApplication.addInitializers(new MyInitializer());
        springApplication.run(args);
        //SpringApplication.run(App.class,args);
    }
}
