package com.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 接收error级别的消息处理器
 *
 * autoDelete ="false "，没有消费的消息不删除
 *
 * Created by lwx on 2019/6/16.
 */
@Component
@RabbitListener(
        bindings =@QueueBinding(
                value = @Queue(value = "${mq.config.queue.error}",autoDelete ="false "),//配置队列名称、是否是一个可删除的临时队列
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.DIRECT),//配置交换器名称、指定交换器类型
                key = "${mq.config.queue.error.routing.key}"
        )
)
public class ErrorReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("error.......receiver:"+msg);
    }
}
