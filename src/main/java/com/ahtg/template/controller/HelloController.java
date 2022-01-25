package com.ahtg.template.controller;

import com.ahtg.template.pojo.Hello;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping("/get")
    public Hello hello(){
        return new Hello("hello world");
    }

    @PostMapping("/create")
    public void create(){

    }

    @PutMapping("/modify")
    public void modify(){

    }

    @PutMapping("/delete")
    public void delete(){

    }
}
