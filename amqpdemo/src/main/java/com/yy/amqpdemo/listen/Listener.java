package com.yy.amqpdemo.listen;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.stereotype.Component;

@Component
public class Listener {
    @RabbitListener(
        bindings = @QueueBinding(
            value = @Queue(value = "spring.test.queue",
                    durable = "false"),
            exchange = @Exchange(value = "spring.test.exchange",
                    ignoreDeclarationExceptions = "true",
                    type = ExchangeTypes.TOPIC),
            key = {"*.*","#.select"}
        )
    )
    public void listen1(String msg){
        System.out.println("接收到消息:"+msg);
    }

    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(
                            value = "spring.test.queue2",
                            durable = "false"
                    ),
                    exchange = @Exchange(value = "spring.test.exchange",
                            type = ExchangeTypes.TOPIC
                    ),
                    key = {"*.update.*","update.#"}
            )
    )
    public void listen2(String msg){
        System.out.println("接到消息:"+msg);
    }
    @RabbitListener(
            bindings = @QueueBinding(
                    value = @Queue(
                            value = "spring.test.queue3",
                            durable = "false"
                    ),
                    exchange = @Exchange(value = "spring.test.exchange",
                            type = ExchangeTypes.TOPIC
                    ),
                    key = {"*.delete.*","delete.#"}
            )
    )
    public void listen3(String msg){
        System.out.println("您有最新的消息请注意查收..."+msg);
    }
}
