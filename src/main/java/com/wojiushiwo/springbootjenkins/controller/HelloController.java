package com.wojiushiwo.springbootjenkins.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by myk
 * 2020/5/13 下午5:35
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/pay")
    public void pay(HttpServletRequest request, HttpServletRequest response) {
        String agent = request.getHeader("User-Agent").toLowerCase();
        System.out.println("响应头的类型：" + agent);
        if (agent.indexOf("micromessenger") > 0) {
            System.out.println("微信支付");
        } else if (agent.indexOf("alipayclient") > 0) {
            System.out.println("阿里支付");
        }
    }
}
