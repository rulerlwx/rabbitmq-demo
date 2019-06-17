package com.demo;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * push消息处理器
 *
 * Created by lwx on 2019/6/16.
 */
@Component
@RabbitListener(
        bindings =@QueueBinding(
                value = @Queue(value = "${mq.config.queue.push}",autoDelete ="true"),//配置队列名称、是否是一个可删除的临时队列
                exchange = @Exchange(value = "${mq.config.exchange}",type = ExchangeTypes.FANOUT)//配置交换器名称、指定交换器类型
        )
)
public class PushReceiver {

    @RabbitHandler
    public void process(String msg){
        System.out.println("push.......receiver:"+msg);
    }
}
