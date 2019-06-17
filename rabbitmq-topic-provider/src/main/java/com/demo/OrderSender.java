package com.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * 订单服务
 *
 * Created by lwx on 2019/6/16.
 */
@Component
public class OrderSender {

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
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.debug","order.log.debug...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.info","order.log.info...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.warn","order.log.warn...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"order.log.error","user.log.error...."+msg);
    }
}
