package com.ahtg.template.controller;

import com.ahtg.template.pojo.Hello;
import com.ahtg.template.pojo.result.RetResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/get")
    public RetResult hello(){
        return RetResult.success(new Hello("hello world"));
    }
}
