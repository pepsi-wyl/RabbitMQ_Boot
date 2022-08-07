package com._pepsiwyl.consumer;

import org.springframework.stereotype.Component;
import org.springframework.amqp.rabbit.annotation.*;

/**
 * @author by pepsi-wyl
 * @date 2022-08-06 21:17
 */

/**
 * HelloWord模型 消费者
 */
@Component
// 消费者监听 类上需要写回调注解 方法上不需要
// queuesToDeclare 队列配置 value-队列名称 durable-是否持久化 exclusive-是否独占 autoDelete-是否自动删除
@RabbitListener(queuesToDeclare = @Queue(value = "HelloWord", durable = "true", exclusive = "false", autoDelete = "true"))
public class HelloWordConsumer {

    // 消费回调函数 消费消息
    @RabbitHandler
    public void Customer(String message) {
        System.out.println("MSG: " + message);
    }

}