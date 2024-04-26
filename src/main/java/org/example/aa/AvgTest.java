//package org.example.aa;
//
//import org.apache.flink.api.common.serialization.DeserializationSchema;
//import org.apache.flink.api.common.serialization.SimpleStringSchema;
//import org.apache.flink.api.common.typeinfo.Types;
//import org.apache.flink.streaming.api.datastream.DataStream;
//import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
//import org.apache.flink.streaming.api.functions.sink.SinkFunction;
//import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
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
// * @title AvgTest
// * @Author: dongms
// * @Date: 2024/3/25
// */
//public class AvgTest {
//
//    public static void main (String[] args) throws Exception {
//        // 设置Flink执行环境
//        StreamExecutionEnvironment env =
//                StreamExecutionEnvironment.getExecutionEnvironment();
//
//        // Kafka参数
//        Properties properties = new Properties();
//        properties.setProperty("bootstrap.servers", "192.168.182.161:9092");
//        properties.setProperty("group.id", "flink-group");
//        String inputTopic = "test";
//
//
//        // Source
//        FlinkKafkaConsumer<Person> consumer = new FlinkKafkaConsumer<>(inputTopic, new PersonDeserializer(), properties);
//        DataStream<Person> stream = env.addSource(consumer).returns(Types.POJO(Person.class));
//
//        stream.addSink(new SinkFunction<Person>() {
//            private Connection connection;
//            private PreparedStatement preparedStatement;
//            @Override
//            public void invoke(Person value, Context context) throws Exception {
//                connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dms", "root", "123456");
//                preparedStatement = connection.prepareStatement("INSERT INTO t_avg_record (id, avg) VALUES (?, ?)");
//                // 将数据插入到 MySQL 中
//                preparedStatement.setString(1, value.getId());
//                preparedStatement.setInt(2, value.getPay());
//                preparedStatement.executeUpdate();
//            }
//            public void close() throws SQLException {
//                if (preparedStatement != null) {
//                    preparedStatement.close();
//                }
//                if (connection != null) {
//                    connection.close();
//                }
//            }
//        });
//
//        env.execute("Flink Kafka Consumer Example");
//
//    }
//}
