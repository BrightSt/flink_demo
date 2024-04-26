//package org.example.kafka;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//
///**
// * 功能描述：
// * 修改记录:
// * <pre>
// * 修改时间：
// * 修改人：
// * 修改内容：
// * </pre>
// *
// * @title KafkaConsumerExample
// * @Author: dongms
// * @Date: 2024/3/26
// */
//public class KafkaConsumerExample {
//    public static void main(String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.182.161:9092");
//        props.put("group.id", "test-group");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Collections.singletonList("test"));
//
//        while (true) {
//            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
//            for ( ConsumerRecord<String, String> record : records) {
//                System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
//            }
//        }
//    }
//}
