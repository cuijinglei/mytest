package com.cjl.comsumer;

import com.rabbitmq.client.*;

public class FirstProducer {
    private static final String HOST_NAME="192.168.81.4";
    private static final int HOST_PORT=30672;
    private static final String QUEUE_NAME="test2";
    public static final String USER_NAME="admin";
    public static final String PASSWORD="admin";
    public static final String VIRTUAL_HOST="/";
    public static void main(String[] args) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost(HOST_NAME);
        factory.setPort(HOST_PORT);
        factory.setUsername(USER_NAME);
        factory.setPassword(PASSWORD);
        factory.setVirtualHost(VIRTUAL_HOST);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //queue,durable,exclusive,autoDelete,arguments
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        AMQP.BasicProperties.Builder builder = new AMQP.BasicProperties.Builder();
        //对应⻚⾯上的Properties部分，传⼊⼀些预定的参数值。
        builder.deliveryMode(MessageProperties.PERSISTENT_TEXT_PLAIN.getDeliveryMode());
        builder.priority(MessageProperties.PERSISTENT_TEXT_PLAIN.getPriority());
        //builder.headers(headers);对应⻚⾯上的Headers部分。传⼊⾃定义的参数值
        builder.build();
        AMQP.BasicProperties prop = builder.build();
        channel.basicPublish("", "test2", prop,"生产者发1".getBytes("UTF-8")) ;
    }
}
