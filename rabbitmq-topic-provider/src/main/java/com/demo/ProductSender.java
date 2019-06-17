package com.demo;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 消息发送者
 *
 * 商品服务
 *
 * Created by lwx on 2019/6/16.
 */
@Component
public class ProductSender {

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
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.debug","product.log.debug...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.info","product.log.info...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.warn","product.log.warn...."+msg);
        this.rabbitAmqpTemplate.convertAndSend(this.exchange,"product.log.error","product.log.error...."+msg);
    }
}
