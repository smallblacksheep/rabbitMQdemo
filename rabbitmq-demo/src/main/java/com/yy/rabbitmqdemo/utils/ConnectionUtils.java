package com.yy.rabbitmqdemo.utils;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * 获取MQ消息队列连接工具类
 */
public class ConnectionUtils {
    //默认连接参数
    private static final String VIRTUAL_HOST = "/mqtest";
    private static final String HOST = "192.168.116.130";
    private static final Integer PORT = 5672;
    private static final String USER_NAME = "shenyinzhao";
    private static final String PASSWORD = "123456";

    /**
     * 获取默认连接
     * @return
     * @throws Exception
     */
    public static final Connection getConnection() throws Exception {
        return getConnection(HOST,PORT,VIRTUAL_HOST,USER_NAME,PASSWORD);
    }

    /**
     * 根据用户提供的链接信息创建链接
     * @param HOST
     * @param VIRTUAL_HOST
     * @param USER_NAME
     * @param PASSWORD
     * @return
     * @throws Exception
     */
    public static final Connection getConnection(String HOST,Integer PORT, String VIRTUAL_HOST, String USER_NAME, String PASSWORD) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST);
        factory.setVirtualHost(VIRTUAL_HOST);
        factory.setPort(PORT);
        factory.setPassword(PASSWORD);
        factory.setUsername(USER_NAME);
        return factory.newConnection();
    }



}
