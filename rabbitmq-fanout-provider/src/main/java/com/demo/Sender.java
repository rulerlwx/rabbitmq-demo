package com.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * Created by lwx on 2019/6/16.
 */
@Component
public class Sender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg) {
        /**
         * 参数一：交换器名称
         * 参数二：路由键
         * 参数三：消息
         *
         * fanout模式，参数二传""
         */
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"",msg);
    }
}
