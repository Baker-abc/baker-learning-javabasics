package com.baker.learning.javabasics.java8.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @link https://www.runoob.com/java/java8-streams.html
 * @link https://colobu.com/2016/03/02/Java-Stream/
 * @description Java 8 API添加了一个新的抽象称为流Stream，可以让你以一种声明的方式处理数据。
 * <p>
 * Stream 使用一种类似用 SQL 语句从数据库查询数据的直观方式来提供一种对 Java 集合运算和表达的高阶抽象
 * <p>
 * 类似SQL语句一样的操作， 比如filter, map, reduce, find, match, sorted等。
 * <p>
 * stream() − 为集合创建串行流。
 * parallelStream() − 为集合创建并行流。
 * <p>
 * <p>
 * 中间操作：
 * distinct
 * filter
 * map
 * flatmap
 * limit
 * peek
 * sorted
 * skip
 * <p>
 * 终点操作：
 * Match
 * count
 * collect
 * find
 * forEach、forEachOrdered
 * max、min
 * reduce
 * toArray()
 * @date 2020/1/1 15:04
 */
public class Demo1 {

    public static void main(String[] args) {
        /**
         * forEach
         */
        System.out.println("======== forEach ===========");
        List<String> list = new ArrayList<>(4);
        list.add("a");
        list.add("b");
        list.add("");
        list.add("c");
        Optional.of(list).ifPresent(strings -> strings.forEach(System.out::println));

        /**
         * map
         */
        System.out.println("========== map ============");
        list.stream().map(i -> "_" + i).collect(Collectors.toList()).forEach(System.out::println);
        list.parallelStream().map(i -> "_" + i).collect(Collectors.toList()).forEach(System.out::println);

        /**
         * filter 方法用于通过设置的条件过滤出元素。以下代码片段使用 filter 方法过滤出空字符串
         */
        System.out.println("========== filter ============");
        list.stream().filter(s -> !s.isEmpty()).forEach(System.out::println);

        /**
         * limit 方法用于获取指定数量的流
         */
        System.out.println("=========== limit ==========");
        list.stream().limit(2).forEach(System.out::println);

        /**
         * sorted 方法用于对流进行排序
         */
        System.out.println("============ sorted ==========");
        List<Integer> integerList = new ArrayList<>(Arrays.asList(2, 3, 7, 3, 4, 9));
        integerList.stream().sorted().forEach(System.out::println);

        /**
         * distinct 去重
         */
        System.out.println("=============== distinct ==============");
        integerList.stream().distinct().sorted().forEach(System.out::println);

        /**
         * Collectors  Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
         */
        System.out.println("============== Collectors =============");
        list.stream().limit(2).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println(list.stream().limit(2).collect(Collectors.joining(",")));

        /**
         * 统计
         */
        System.out.println("============= 统计 =============");
        IntSummaryStatistics intSummaryStatistics = integerList.stream().distinct().mapToInt((x) -> x).summaryStatistics();
        System.out.println("最大：" + intSummaryStatistics.getMax());
        System.out.println("最小：" + intSummaryStatistics.getMin());
        System.out.println("求和：" + intSummaryStatistics.getSum());
        System.out.println("求平均：" + intSummaryStatistics.getAverage());
        System.out.println("总数：" + intSummaryStatistics.getCount());

        /**
         * 其他方法
         */
        System.out.println("========= peek 可以先执行一些东西 ");
        System.out.println("个数：" + integerList.stream().peek(System.out::println).count());
        System.out.println("========= skip 排除一些东西  ");
        integerList.stream().skip(2).forEach(System.out::println);
        System.out.println("============= findAny返回任意一个元素，一般是第一个。  使用并行流的话随机==============");
        System.out.println(integerList.stream().findAny().get());
        System.out.println(integerList.parallelStream().findAny().get());
        System.out.println("============= forEachOrdered 在并行操作中依然保证顺序执行 forEach反之 ==============");
        integerList.parallelStream().forEachOrdered(System.out::println);
        System.out.println("============= match ==============");
        System.out.println("每个元素都大于4的：" + integerList.stream().allMatch(integer -> integer > 4));
        System.out.println("存在大于4的：" + integerList.stream().anyMatch(integer -> integer > 4));
        System.out.println("没有大于4的：" + integerList.stream().noneMatch(integer -> integer > 4));
        System.out.println("============= reduce 对stream中的元素进行操作，比如相加 ==============");
        System.out.println(integerList.stream().limit(2).reduce((x, y) -> x + y).get());
        System.out.println(integerList.stream().limit(2).reduce(1, (x, y) -> x + y));
        System.out.println("============= Stream.of() 创建一个流 ==============");
        System.out.println(Stream.of(1, 2, 5, 3).collect(Collectors.toList()));
        System.out.println("============= Stream.concat 合并流 ==============");
        System.out.println(Stream.concat(integerList.stream(), Stream.of(1, 2, 5, 3)).count());


    }
}
