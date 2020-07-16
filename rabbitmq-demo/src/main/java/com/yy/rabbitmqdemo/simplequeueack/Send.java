package com.yy.rabbitmqdemo.simplequeueack;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

public class Send {

    public static final String QUEUE_NAME = "simple_queue";

    public static void main(String[] args) {
        //获取连接
        Connection conn = null;
        Channel channel = null;
        try {
            conn = ConnectionUtils.getConnection();
            //创建连接通道
            channel = conn.createChannel();
            //声明一个生产者队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);
            //填充消息内容
            String str = "你说谁是小个子....";
            //生产者发布消息到队列中
            channel.basicPublish("",QUEUE_NAME,null,str.getBytes());
            System.out.println("simplequeue send : " + str);


        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭通道和连接
            try {
                channel.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }


    }


}
