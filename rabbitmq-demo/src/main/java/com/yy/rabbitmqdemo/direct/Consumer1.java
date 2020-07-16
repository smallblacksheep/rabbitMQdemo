package com.yy.rabbitmqdemo.direct;

import com.rabbitmq.client.*;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.io.IOException;

public class Consumer1 {
    private static final String QUEUE_NAME = "direct_queue_1";
    public static final void consumer(){
        //获取连接
        try {
            Connection conn = ConnectionUtils.getConnection();
            //创建通道
            Channel channel = conn.createChannel();
            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //队列绑定交换机
            channel.queueBind(QUEUE_NAME,Productor.EXCHANGE_NAME,"info");
            channel.queueBind(QUEUE_NAME,Productor.EXCHANGE_NAME,"waring");
            channel.queueBind(QUEUE_NAME,Productor.EXCHANGE_NAME,"insert");
            channel.queueBind(QUEUE_NAME,Productor.EXCHANGE_NAME,"update");

            //消费消息
            channel.basicConsume(QUEUE_NAME,false,new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("Consumer1消费类型:"+envelope.getRoutingKey()+";消费内容:"+new String(body,"UTF-8"));
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
