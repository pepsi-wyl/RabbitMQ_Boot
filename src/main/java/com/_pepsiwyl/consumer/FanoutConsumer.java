package com._pepsiwyl.consumer;

import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-08-06 21:57
 */

/**
 * fanout模型 消费者
 */
@Component
public class FanoutConsumer {

    // 消费者监听 不需要写回调注解
    @RabbitListener(bindings = {
            // 绑定队列和交换机
            @QueueBinding(
                    // 临时队列
                    value = @Queue,
                    // 交换机 value-交换机名称  type-类型(fanout)
                    exchange = @Exchange(value = "logs_fanout", type = "fanout")
            )
    })
    public void Customer1(String message) {
        System.out.println("MSG1: " + message);
    }

    @RabbitListener(bindings = {
            @QueueBinding(
                    value = @Queue,
                    exchange = @Exchange(value = "logs_fanout", type = "fanout")
            )
    })
    public void Customer2(String message) {
        System.out.println("MSG2: " + message);
    }

}