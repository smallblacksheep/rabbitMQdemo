package com.yy.rabbitmqdemo.work;

import com.rabbitmq.client.*;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.io.IOException;

public class Work1 {

    private static final String QUEUE_NAME = "work_queue";

    public static final void work(){
        //获取连接
        try {
            Connection conn = ConnectionUtils.getConnection();
            //创建通道
            Channel channel = conn.createChannel();

            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //创建消费函数

            //消费消息
            channel.basicConsume(QUEUE_NAME,false, new DefaultConsumer(channel){
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    System.out.println("work1消费:"+new String(body,"UTF-8"));
                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }


        //
    }
}
