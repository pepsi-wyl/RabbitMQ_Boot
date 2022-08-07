package com._pepsiwyl.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @author by pepsi-wyl
 * @date 2022-08-07 9:35
 */

@RestController
public class RabbitMQController {

    // 注入RabbitTemplate
    private final RabbitTemplate rabbitTemplate;

    public RabbitMQController(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }


    /**
     * HelloWord模型 生产者
     */
    @GetMapping("/helloWord")
    public String helloWord() {
        // 1.发送的队列  2.发送的消息
        rabbitTemplate.convertAndSend("HelloWord", "Hello Word !!!");
        return "OK~";
    }

    /**
     * WorkQueue模型 生产者
     */
    @GetMapping("/workQueue")
    public String workQueue() {
        for (int i = 1; i <= 10; i++) {
            // 1.发送的队列  2.发送的消息
            rabbitTemplate.convertAndSend("WorkQueue", "WorkQueue 模型消息: " + i);
        }
        return "OK~";
    }

    /**
     * fanout模型 生产者
     */
    @GetMapping("/fanout")
    public String fanout() {
        // 1.交换机 2.路由key 3.发送的消息
        rabbitTemplate.convertAndSend("logs_fanout", "", "fanout 模型消息");
        return "OK~";
    }

    /**
     * direct模型 生产者
     */
    @GetMapping("/direct")
    public String direct() {
        // 1.交换机 2.路由key 3.发送的消息
        rabbitTemplate.convertAndSend("logs_direct", "info", "info-key的路由信息");
        rabbitTemplate.convertAndSend("logs_direct", "warning", "warning-key的路由信息");
        rabbitTemplate.convertAndSend("logs_direct", "error", "info-error的路由信息");
        return "OK~";
    }

    /**
     * toptic模型 生产者
     */
    @GetMapping("/toptic")
    public String toptic() {
        // 1.交换机 2.路由key 3.发送的消息
        rabbitTemplate.convertAndSend("logs_topic", "save.user.delete", "save.user.delete 路由信息");
        rabbitTemplate.convertAndSend("logs_topic", "save.user.delete.findAll", "save.user.delete.findAll 路由信息");
        return "OK~";
    }

}