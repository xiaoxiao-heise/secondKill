package com.imooc.miaosha.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/vue")
public class VueController {

    @RequestMapping("/test")
    public String vueTest(){
        return "vue";
    }

}
