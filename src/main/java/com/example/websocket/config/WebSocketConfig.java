package com.example.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
@Configuration
@EnableWebSocketMessageBroker//开启消息代理
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
    public void configureMessageBroker(MessageBrokerRegistry config){
      //设置消息代理的前缀，如果消息的前缀是"/topic",就会将消息转发给消息代理(broker)
        //再由消息代理将消息广播给当前连接的客户端
        config.enableSimpleBroker("/topic");
        //表示配置一个或多个前缀，通过这些前缀过滤出被注解方法处理的消息
        config.setApplicationDestinationPrefixes("/app");
    }
    public void registerStompEndpoints(StompEndpointRegistry registry){
        //定义前缀为chat的endpoint,并开启sockjs支持，sockjs可以解决浏览器对websocket的兼容性问题
        registry.addEndpoint("/chat").withSockJS();
    }
}
