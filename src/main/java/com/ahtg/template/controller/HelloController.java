package com.ahtg.template.controller;

import com.ahtg.template.pojo.Hello;
import com.ahtg.template.pojo.result.RetResult;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/get")
    public Hello hello(){
        return new Hello("hello world");
    }

    @PostMapping("/create")
    public void createHello(){

    }

    @PutMapping("/create")
    public void putHello(){

    }

    @PutMapping("/delete")
    public void deleteHello(){

    }
}
