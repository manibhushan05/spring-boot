package com.manibhushan.springdemo.controller;

import com.manibhushan.springdemo.model.Greeting;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloWorldController {
    private static final String template = "Hello, %s!";
    private static AtomicLong counter = new AtomicLong();

    @RequestMapping(path = "/greeting",method = RequestMethod.GET)
    public Greeting greeting(@RequestParam(value="name",defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
    }
}
