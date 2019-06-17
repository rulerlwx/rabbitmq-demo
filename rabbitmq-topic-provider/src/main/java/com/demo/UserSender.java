package com.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * 用户服务
 *
 * Created by lwx on 2019/6/16.
 */
@Component
public class UserSender {

    @Autowired
    private AmqpTemplate rabbitAmqpTemplate;

    @Value("${mq.config.exchange}")
    private String exchange;

    public void send(String msg) {
        /**
         * 参数一：交换器名称
         * 参数二：路由键
         * 参数三：消息
         */
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.debug","user.log.debug...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.info","user.log.info...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.warn","user.log.warn...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"user.log.error","user.log.error...."+msg);
    }
}
