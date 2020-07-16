package com.yy.rabbitmqdemo.simplequeueack;

import com.rabbitmq.client.*;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.io.IOException;

public class Consumer {
    private static final String QUEUE_NAME = "simple_queue";
    public static void main(String[] args) {
        //获取连接
        try {
            Connection connection = ConnectionUtils.getConnection();
            //创建通道
            Channel channel = connection.createChannel();

            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false ,null);

            //定义队列的消费者
            DefaultConsumer consumer = new DefaultConsumer(channel){

                // 获取消息，并且处理，这个方法类似事件监听，如果有消息的时候，会被自动调用
                @Override
                public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                    //消费信息
                    String msg = new String(body);

                    System.out.println(msg);

                    int num = 1/0;

                    channel.basicAck(envelope.getDeliveryTag(),false);
                }
            };
            //
            channel.basicConsume(QUEUE_NAME,false,consumer);

            //关闭通道和连接(不能关闭连接)

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
