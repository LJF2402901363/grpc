package com.grpc.controller;

import com.grpc.client.AutoChatClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Classname:GrpcTestController
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2021-04-01 11:30
 * @Version: 1.0
 **/
@Controller
@RequestMapping("/shiyun")
public class GrpcTestController {
    @Autowired
    private AutoChatClient autoChatClient;
    @GetMapping("/test/{name}")
    @ResponseBody
    public Map<String,String>  test(@PathVariable("name")String name){
         String str = autoChatClient.sendQuestion(name);
        Map<String,String> map = new HashMap<>();
        map.put("msg",str);
        return  map;
    }
}
