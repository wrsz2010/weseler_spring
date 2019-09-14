package com.javadub1.weseler_spring;

import org.springframework.stereotype.Component;

@Component
public class HelloBean {
    public void hello() {
        System.out.println("Hello World");
    }
}
