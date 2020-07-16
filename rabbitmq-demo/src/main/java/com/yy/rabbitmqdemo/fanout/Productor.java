package com.yy.rabbitmqdemo.fanout;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.io.IOException;
import java.util.List;

public class Productor  {
    public static final String EXCHANGE_NAME = "fanout_exchange";
    public static final void product(List<String> msgs){
        //获取连接
        Connection conn = null;
        Channel channel = null;
        try {
            conn = ConnectionUtils.getConnection();
            //创建通道
            channel = conn.createChannel();
            //声明路由
            channel.exchangeDeclare(EXCHANGE_NAME,"fanout");
            //发布消息
            for (String msg : msgs) {
                channel.basicPublish(EXCHANGE_NAME,"",null,msg.getBytes("UTF-8"));
            }
            //关闭连接

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                channel.close();
                conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
