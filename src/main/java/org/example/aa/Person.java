//package org.example.aa;
//
//import org.apache.kafka.common.serialization.Deserializer;
//import org.apache.kafka.common.serialization.Serializer;
//
//import java.util.Map;
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
// * @title Person
// * @Author: dongms
// * @Date: 2024/3/26
// */
//public class Person implements Serializer<Person>, Deserializer<Person> {
//
//    @Override
//    public byte[] serialize(String topic, Person data) {
//        // 实现将 Person 对象序列化为字节数组的逻辑
//        if (data == null) {
//            return null;
//        }
//        // 将 Person 对象转换为字节数组的逻辑
//        return data.toString().getBytes();
//    }
//
//    @Override
//    public Person deserialize(String topic, byte[] data) {
//        // 实现将字节数组反序列化为 Person 对象的逻辑
//        if (data == null) {
//            return null;
//        }
//        // 将字节数组转换为 Person 对象的逻辑
//        String personString = new String(data);
//        String[] parts = personString.split(",");
//        String name = parts[0];
//        int age = Integer.parseInt(parts[1]);
//        return new Person(name, age);
//    }
//
//    @Override
//    public void close() {
//        // 关闭资源的逻辑
//    }
//
//    @Override
//    public void configure(Map<String, ?> configs, boolean isKey) {
//        // 配置初始化的逻辑
//    }
//
//    private String id;
//
//    private Integer pay;
//
//    public Person () {
//    }
//
//    public Person (String number, int i) {
//    }
//
//
//    public String getId () {
//        return id;
//    }
//
//    public void setId (String id) {
//        this.id = id;
//    }
//
//    public Integer getPay () {
//        return pay;
//    }
//
//    public void setPay (Integer pay) {
//        this.pay = pay;
//    }
//}
