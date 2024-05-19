package com.eventframe.demo.framework.mq;



import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class EventDrivenModelMq {

    private static final String BROKER_URL = "tcp://localhost:61616";
    private static final String QUEUE_NAME = "event_queue";

    public static void main(String[] args) throws JMSException {
        // 创建连接工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(BROKER_URL);

        // 创建连接
        Connection connection = connectionFactory.createConnection();

        // 启动连接
        connection.start();

        // 创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // 创建事件队列
        Destination queue = session.createQueue(QUEUE_NAME);

        // 创建生产者
        MessageProducer producer = session.createProducer(queue);

        // 创建消费者
        MessageConsumer consumer = session.createConsumer(queue);

        // 设置消息监听器
        consumer.setMessageListener(new MessageListener() {
            public void onMessage(Message message) {
                try {
                    // 处理接收到的消息
                    System.out.println("Received message: " + ((TextMessage)message).getText());
                } catch (JMSException e) {
                    e.printStackTrace();
                }
            }
        });

        // 发送事件消息
        for (int i = 1; i <= 10; i++) {
            TextMessage message = session.createTextMessage("Event " + i);
            producer.send(message);
            System.out.println("Sent message: " + message.getText());
        }

        // 等待接收消息
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // 关闭连接
        connection.close();
    }
}
