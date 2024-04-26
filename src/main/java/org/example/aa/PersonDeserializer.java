//package org.example.aa;
//
//import org.apache.flink.api.common.serialization.DeserializationSchema;
//import org.apache.flink.api.common.typeinfo.TypeInformation;
//import org.apache.kafka.common.serialization.Deserializer;
//
//import java.io.ByteArrayInputStream;
//import java.io.IOException;
//import java.io.ObjectInputStream;
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
// * @title PersonDeserializer
// * @Author: dongms
// * @Date: 2024/3/26
// */
//public class PersonDeserializer implements DeserializationSchema<Person> {
//    @Override
//    public Person deserialize (byte[] bytes) throws IOException {
//        try {
//            ByteArrayInputStream byteStream = new ByteArrayInputStream(bytes);
//            ObjectInputStream objectInputStream = new ObjectInputStream(byteStream);
//            return (Person) objectInputStream.readObject();
//        } catch (Exception e) {
//            throw new RuntimeException("Error deserializing Person object: " + e);
//        }
//    }
//
//    @Override
//    public boolean isEndOfStream (Person person) {
//        return false;
//    }
//
//    @Override
//    public TypeInformation<Person> getProducedType () {
//        return null;
//    }
//}
