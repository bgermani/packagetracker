package com.bgermani.packagetracker.event;

import org.springframework.context.annotation.Bean;
import org.springframework.integration.config.GlobalChannelInterceptor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
public class Interceptor {
    @Bean
    @GlobalChannelInterceptor(patterns = "packageEvents-*")
    public ChannelInterceptor customInterceptor() {
        return new ChannelInterceptor() {
            @Override
            public Message<?> preSend(Message<?> message, MessageChannel channel) {
                System.out.println(message.getPayload().toString());
                System.out.println("ChannelInterceptor");
                return message;
            }
        };
    }
}
