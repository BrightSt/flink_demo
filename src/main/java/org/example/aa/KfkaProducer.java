//package org.example.aa;
//
//import org.apache.kafka.clients.consumer.ConsumerRecord;
//import org.apache.kafka.clients.consumer.ConsumerRecords;
//import org.apache.kafka.clients.consumer.KafkaConsumer;
//import org.apache.kafka.clients.producer.KafkaProducer;
//import org.apache.kafka.clients.producer.ProducerRecord;
//import org.apache.kafka.clients.producer.RecordMetadata;
//
//import java.time.Duration;
//import java.util.Collections;
//import java.util.Properties;
//import java.util.concurrent.Future;
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
// * @title KfkaProducer
// * @Author: dongms
// * @Date: 2024/3/26
// */
//public class KfkaProducer {
//
//    public static void main (String[] args) {
//        Properties props = new Properties();
//        props.put("bootstrap.servers", "192.168.182.161:9092");
//        props.put("group.id", "test-group");
//        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
//        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
//        props.put("value.serializer", Person.class.getName());
//
//        KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
//        consumer.subscribe(Collections.singletonList("test"));
//
//
//        KafkaProducer<String,Person> producer = new KafkaProducer<>(props);
//        producer.send(new ProducerRecord<>("test", new Person("1", 100)));
//        producer.send(new ProducerRecord<>("test", new Person("1", 200)));
//        producer.send(new ProducerRecord<>("test", new Person("1", 300)));
//        producer.close();
//        System.out.println("数据插入成功");
//    }
//}
