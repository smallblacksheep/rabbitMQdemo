package com.yy.rabbitmqdemo.topic;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.util.List;

public class Productor {
    //交换机名称
    public static final String EXCHANGE_NAME = "topic_exchange";

    /**
     *
     * @param msgs
     * @param keys
     */
    public static final void product(List<String> msgs,List<String> keys){
        //获取连接
        Connection conn = null;
        Channel channel = null;
        try {
            conn = ConnectionUtils.getConnection();
            //创建通道
            channel = conn.createChannel();
            //声明交换机
            channel.exchangeDeclare(EXCHANGE_NAME,"topic");

            //发布消息
            for (int i = 0; i < msgs.size(); i++) {
                channel.basicPublish(EXCHANGE_NAME,keys.get(i),null,msgs.get(i).getBytes("UTF-8"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            //关闭连接
            try {
                channel.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
