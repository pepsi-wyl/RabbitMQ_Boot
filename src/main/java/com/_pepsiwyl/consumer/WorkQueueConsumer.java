package com._pepsiwyl.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author by pepsi-wyl
 * @date 2022-08-06 21:49
 */


/**
 * WorkQueue模型 消费者
 */
@Component
public class WorkQueueConsumer {

    // 消费者监听 类上需要写回调注解 方法上不需要
    // queuesToDeclare 队列配置 value-队列名称 durable-是否持久化 exclusive-是否独占 autoDelete-是否自动删除
    @RabbitListener(queuesToDeclare = @Queue(value = "WorkQueue", durable = "true", exclusive = "false", autoDelete = "true"))
    public void Customer1(String message) {
        System.out.println("MSG1: " + message);
    }

    @RabbitListener(queuesToDeclare = @Queue(value = "WorkQueue", durable = "true", exclusive = "false", autoDelete = "true"))
    public void Customer2(String message) {
        System.out.println("MSG2: " + message);
    }

}