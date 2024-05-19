package com.eventframe.demo.framework.mq;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

/**
 * 生产者将事件发送到名为 "events" 的主题，消费者监听该主题并处理接收到的事件，然后发送回复事件。你可以根据自己的需求修改代码。
 * 记得在运行代码之前，先启动 Kafka 服务器并创建名为 "events" 的主题。
 */
public class EventDrivenModel {

    private static final String BOOTSTRAP_SERVERS = "localhost:9092";
    private static final String TOPIC = "events";

    public static void main(String[] args) {
        // 创建生产者
        KafkaProducer<String, String> producer = createProducer();

        // 创建消费者
        KafkaConsumer<String, String> consumer = createConsumer();

        // 订阅主题
        consumer.subscribe(Collections.singletonList(TOPIC));

        // 监听事件并处理
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
            for (ConsumerRecord<String, String> record : records) {
                // 处理事件
                System.out.println("Received event: " + record.value());

                // 发送回复事件
                ProducerRecord<String, String> replyRecord = new ProducerRecord<>(TOPIC, "Reply event for: " + record.value());
                producer.send(replyRecord);
            }
        }
    }

    private static KafkaProducer<String, String> createProducer() {
        Properties props = new Properties();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        return new KafkaProducer<>(props);
    }

    private static KafkaConsumer<String, String> createConsumer() {
        Properties props = new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, BOOTSTRAP_SERVERS);
        props.put(ConsumerConfig.GROUP_ID_CONFIG, "event-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
        return new KafkaConsumer<>(props);
    }
}
