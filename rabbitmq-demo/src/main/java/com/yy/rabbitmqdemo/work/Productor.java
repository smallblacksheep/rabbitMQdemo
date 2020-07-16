package com.yy.rabbitmqdemo.work;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.yy.rabbitmqdemo.utils.ConnectionUtils;

import java.util.List;

public class Productor {
    private static final String QUEUE_NAME = "work_queue";
    public static void produ(List<String> msgs){
        //获取连接
        Connection conn = null;
        Channel channel = null;
        try {

            conn = ConnectionUtils.getConnection();

            //创建通道
            channel = conn.createChannel();
            //声明队列
            channel.queueDeclare(QUEUE_NAME,false,false,false,null);

            for (int i = 0; i < 100; i++) {
                String msg = "任务号" + (i+1) +" : " + msgs.get(i % msgs.size());
                //发布消息
                channel.basicPublish("",QUEUE_NAME,null,msg.getBytes());
                System.out.println("生产者发布任务,"+msg);
                Thread.sleep(2000);
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
