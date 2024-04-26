package org.example.wordcount;

import org.apache.flink.api.common.functions.FlatMapFunction;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.LocalEnvironment;
import org.apache.flink.api.java.operators.AggregateOperator;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.operators.FlatMapOperator;
import org.apache.flink.api.java.operators.UnsortedGrouping;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.streaming.api.datastream.DataStreamSource;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.util.Collector;
import sun.util.resources.vi.LocaleNames_vi;

/**
 * 功能描述：
 * 修改记录:
 * <pre>
 * 修改时间：
 * 修改人：
 * 修改内容：
 * </pre>
 *
 * @title WordCountTest
 * @Author: dongms
 * @Date: 2024/3/30
 */
public class WordCountTest {

    public static void main (String[] args) throws Exception {
        // 环境
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        // 读取
        DataStreamSource<String> stringDataSource = env.readTextFile("input/word.txt");

         // 处理数据
        final FlatMapOperator<String, Tuple2<String, Integer>> stringTuple2FlatMapOperator = stringDataSource.flatMap(new FlatMapFunction<String, Tuple2<String, Integer>>() {
            @Override
            public void flatMap (String value, Collector<Tuple2<String, Integer>> out) throws Exception {
                String[] strings = value.split(" ");
                for ( String word : strings ) {
                    final Tuple2<String, Integer> stringIntegerTuple2 = Tuple2.of(word, 1);
                    out.collect(stringIntegerTuple2);
                }
            }
        });

        final UnsortedGrouping<Tuple2<String, Integer>> tuple2UnsortedGrouping = stringTuple2FlatMapOperator.groupBy(0);

        final AggregateOperator<Tuple2<String, Integer>> sum = tuple2UnsortedGrouping.sum(1);

        sum.print();
    }
}
