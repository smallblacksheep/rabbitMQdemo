package com.yy.amqpdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "发送amqp消息")
@RestController
@RequestMapping(value = "/amqp")
public class TestAMQPController {
    @Autowired
    AmqpTemplate amqpTemplate;

    @Autowired
    RabbitTemplate rabbitTemplate;
    @ApiOperation(notes = "测试消息",value = "发送消息")
    @GetMapping(value = "/testMQ")
    public String testMQ(){
        amqpTemplate.convertAndSend("spring.test.exchange","update.select","你说谁是小个子....");
        return "发送成功~~";
    }

    @GetMapping(value = "/testMQ2")
    public String testMQ2(){
        rabbitTemplate.convertAndSend("spring.test.exchange","delete.select","不管是用爪还是用矛....");
        return "发送成功~~";
    }

    @GetMapping(value = "/testMQ3")
    public String testMQ3(){
        amqpTemplate.convertAndSend("spring.test.exchange","hah.update.hge","我还以为你从来都不会选我呢....");
        return "发送成功~~";
    }
}
