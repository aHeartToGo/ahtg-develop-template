package com.ahtg.template.controller;

import com.ahtg.template.annotation.ApiVersion;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/{version}")
@Slf4j
public class VersionController {

    @ApiOperation("查默认版本")
    @GetMapping("/hello")
    public String getHello(){
        System.out.println("hello default");
        return "hello default";
    }

    @ApiOperation("查1.0.0版本")
    @GetMapping("/hello")
    @ApiVersion("1.0.0")
    public String getHelloV1(){
        System.out.println("hello V1");
        return "hello V1.0.0";
    }

    @GetMapping("/hello")
    @ApiVersion("2.0.0")
    @ApiOperation("查2.0.0版本")
    public String getHelloV2(){
        System.out.println("hello V2");
        return "hello V2.0.0";
    }

}
