package com.baker.learning.javabasics.java8.date;

import java.time.*;

/**
 * @description Java 8通过发布新的Date-Time API (JSR 310)来进一步加强对日期与时间的处理。
 * <p>
 * 在旧版的 Java 中，日期时间 API 存在诸多问题，其中有：
 * <p>
 * 非线程安全 − java.util.Date 是非线程安全的，所有的日期类都是可变的，这是Java日期类最大的问题之一。
 * <p>
 * 设计很差 − Java的日期/时间类的定义并不一致，在java.util和java.sql的包中都有日期类，此外用于格式化和解析的类在java.text包中定义。java.util.Date同时包含日期和时间，而java.sql.Date仅包含日期，将其纳入java.sql包并不合理。另外这两个类都有相同的名字，这本身就是一个非常糟糕的设计。
 * <p>
 * 时区处理麻烦 − 日期类并不提供国际化，没有时区支持，因此Java引入了java.util.Calendar和java.util.TimeZone类，但他们同样存在上述所有的问题。
 * <p>
 * <p>
 * <p>
 * <p>
 * Java 8 在 java.time 包下提供了很多新的 API。以下为两个比较重要的 API：
 * <p>
 * Local(本地) − 简化了日期时间的处理，没有时区的问题。
 * <p>
 * Zoned(时区) − 通过制定的时区处理日期时间。
 * <p>
 * 新的java.time包涵盖了所有处理日期，时间，日期/时间，时区，时刻（instants），过程（during）与时钟（clock）的操作。
 * @date 2019/12/31 8:45
 */
public class Demo1 {
    public static void main(String[] args) {
        new Demo1().testLocalDateTime();

        System.out.println("============= 时区 =================");
        new Demo1().testZonedDateTime();
    }

    public void testLocalDateTime() {
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("当前时间：" + localDateTime);

        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println("当前时间date：" + localDate);
        System.out.println("年：" + localDateTime.getYear());
        System.out.println("月：" + localDateTime.getMonth());
        System.out.println("时：" + localDateTime.getHour());
        System.out.println("分：" + localDateTime.getMinute());
        System.out.println("秒：" + localDateTime.getSecond());

        System.out.println("date：" + localDateTime.withDayOfMonth(10).withYear(2012));
        System.out.println("date：" + localDateTime.withDayOfYear(10).withYear(2012));

        System.out.println(LocalDate.of(2018, 8, 8));
        System.out.println(LocalDate.of(2018, Month.NOVEMBER, 8));

        System.out.println(LocalTime.of(10, 10, 59));

        System.out.println(LocalTime.parse("20:12:20"));


    }

    public void testZonedDateTime() {
        ZonedDateTime date1 = ZonedDateTime.parse("2015-12-03T10:15:30+05:30[Asia/Shanghai]");
        System.out.println("date1: " + date1);

        ZoneId id = ZoneId.of("Europe/Paris");
        System.out.println("ZoneId: " + id);

        ZoneId currentZone = ZoneId.systemDefault();
        System.out.println("当期时区: " + currentZone);
    }


}
