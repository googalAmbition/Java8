package com.ctc.time;

import org.junit.Test;

import javax.sound.midi.Soundbank;
import java.text.MessageFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;

/**
 * java.time
 * Instant：时间戳
 * Duration：持续时间，时间差
 * LocalDate：只包含日期，比如：2016-10-20
 * LocalTime：只包含时间，比如：23:12:10
 * LocalDateTime：包含日期和时间，比如：2016-10-20 23:14:21
 * Period：时间段
 * ZoneOffset：时区偏移量，比如：+8:00
 * ZonedDateTime：带时区的时间
 * Clock：时钟，比如获取目前美国纽约的时间
 * <p>
 * java.time.format
 * DateTimeFormatter：时间格式化
 *
 * @author Administrator
 */
public class DemoTest {

    /**
     * 获取今天日期
     */
    @Test
    public void test1() {
        LocalDate today = LocalDate.now();
        System.out.println(MessageFormat.format("today is: {0}", today));
    }

    /**
     * 指定日期进行相应操作
     */
    @Test
    public void test2() {
        LocalDate today = LocalDate.now();
        //月份第一天
        LocalDate firstDate = today.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(MessageFormat.format("first day of month:{0}", firstDate));
        //月份第一天
        LocalDate firstDate2 = today.withDayOfMonth(1);
        System.out.println(MessageFormat.format("first day of month:{0}", firstDate2));

        //月份最后一天
        LocalDate lastDate = today.with(TemporalAdjusters.lastDayOfMonth());
        System.out.println(MessageFormat.format("last day of month:{0}", lastDate));
        //当前日期+1(tomorrow)
        LocalDate tomorrow = today.plusDays(1);
        System.out.println(MessageFormat.format("tomorrow:{0}", tomorrow));
        //判断是否为闰年
        boolean isLeapYear = today.isLeapYear();
        System.out.println(MessageFormat.format("is leap year:{0}", isLeapYear));
    }

    /**
     * 生日检查或账单日检查
     */
    @Test
    public void test3(){
        LocalDate birthday = LocalDate.of(1993,12,16);
        MonthDay birthdayMd = MonthDay.of(birthday.getMonth(),birthday.getDayOfMonth());
        MonthDay today = MonthDay.of(12,16);
        System.out.println(birthdayMd.equals(today));
    }

    /**
     * 获取当前时间
     */
    @Test
    public void test4(){
        LocalTime now = LocalTime.now();
        System.out.println(now);
        LocalTime now2 = now.withNano(0);
        System.out.println(now2);
        LocalTime time = LocalTime.of(12,12,12);
        System.out.println(time);
        LocalTime time2 = LocalTime.parse("12:12:12");
        System.out.println(time2);
        LocalTime timePlus = now.plusHours(1);
        System.out.println(timePlus);
        LocalTime timePlus2 = now.plus(2,ChronoUnit.HOURS);
        System.out.println(timePlus2);
    }

    /**
     * 日期前后比较
     */
    @Test
    public void test5(){
        LocalDate today = LocalDate.now();
        LocalDate specifyDate = LocalDate.of(2018,10,25);
        System.out.println(today.isAfter(specifyDate));
    }

    /**
     * 处理不同时区的时间
     */
    @Test
    public void test6(){
        ZoneId defaultZone = ZoneId.systemDefault();
        System.out.println(defaultZone);

        ZoneId america = ZoneId.of("America/New_York");

        LocalDateTime shanghai = LocalDateTime.now();
        LocalDateTime americaDatetime = LocalDateTime.now(america);
        System.out.println(shanghai);
        System.out.println(americaDatetime);

        ZonedDateTime us = ZonedDateTime.now(america);
        System.out.println(us);
    }

    /**
     * 比较两个日期之差
     */
    @Test
    public void test7(){
        LocalDate today = LocalDate.now();
        LocalDate birthday = LocalDate.of(1993,12,16);
        System.out.println(MessageFormat.format("{0}======{1}",birthday,today));
        Period period = Period.between(birthday,today);
        System.out.println(period.getDays());
        System.out.println(period.getMonths());
        System.out.println(period.getYears());
        System.out.println(birthday.until(today,ChronoUnit.DAYS));
    }

    /**
     * 日期时间格式解析、格式化
     */
    @Test
    public void test8(){
        String dateString = "20180203";
        DateTimeFormatter formatter = DateTimeFormatter.BASIC_ISO_DATE;
        LocalDate formatted = LocalDate.parse(dateString,formatter);
        System.out.println(formatted);
    }

    /**
     * 时间类与日期类相互转化
     */
    @Test
    public void test9(){
        //
        Instant instant1 = Instant.now();
        System.out.println(instant1);
        Date date1 = Date.from(instant1);
        System.out.println(date1);
        instant1 = date1.toInstant();
        System.out.println(instant1);

        //
        Date date2 = new Date();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(date2.toInstant(),ZoneId.systemDefault());

        //
        LocalDateTime localDateTime3 = LocalDateTime.now();
        Instant instant3 = localDateTime3.atZone(ZoneId.systemDefault()).toInstant();
        Date date3 = Date.from(instant3);
        //

        LocalDate localDate4 = LocalDate.now();
        Instant instant4 = localDate4.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date4 = Date.from(instant4);
    }
}

