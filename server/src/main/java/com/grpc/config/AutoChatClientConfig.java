package com.grpc.config;

import com.grpc.client.AutoChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Classname:AutoChatClientConfig
 *
 * @description:
 * @author: 陌意随影
 * @Date: 2021-04-01 11:34
 * @Version: 1.0
 **/
@Configuration
public class AutoChatClientConfig {
    @Value("${autochat.host}")
    private String host ;
    @Value("${autochat.port}")
    private int port ;
    @Bean
    public AutoChatClient autoChatClient(){
        AutoChatClient client = null;
        try {
            client =   new AutoChatClient(host,port);
            System.out.println("启动客户端连接成功！");
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            return client;
        }


    }
}
