/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JodaTest.java
 * Author:   yichao
 * Date:    16/8/30 下午2:25
 * Description:
 */
package org.trlove.common.test.util.joda;

import org.joda.time.*;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.trlove.common.test.util.guava.GuavaDemo;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Date;
import java.util.TimeZone;

/**
 * JodaTest
 *
 * @author yichao
 * @date 16/8/30
 */
public class JodaTest {

    public static void main(String[] args) {
        dateTime();
    }

    public static void dateTime() {
        DateTime dateTime = DateTime.now();
//        DateTime dateTimeWithTimeZone = DateTime.now(DateTimeZone.forTimeZone(TimeZone.getTimeZone("IST")));
        print(dateTime);
//        print(dateTimeWithTimeZone);
        print(dateTime.withTimeAtStartOfDay());
        print(dateTime.withTimeAtStartOfDay().minusMillis(1));
        print(dateTime.plusDays(1).plusHours(1).plusYears(1));
        print(DateTime.parse("2016-11"));
        print(DateTime.parse("2016-11-12"));
        print(DateTime.parse("2016-11-11 10:11:11", DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss")));
        print(dateTime.withHourOfDay(6));
        print(dateTime.withMonthOfYear(3));
        System.out.println(dateTime.millisOfDay().withMaximumValue().toDate());
        System.out.println(Days.daysBetween(dateTime, dateTime.withHourOfDay(0)).getDays());
        System.out.println(Days.daysBetween(dateTime, dateTime.plusHours(24)).getDays());
        System.out.println(Days.daysBetween(dateTime.withTimeAtStartOfDay(), DateTime.parse("2016-11-11 10:11:11", DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss")).withTimeAtStartOfDay()).getDays());
        System.out.println(DateTime.now().withTimeAtStartOfDay().toDate());
        MonthDay monthDay = MonthDay.now();
        System.out.println(monthDay);
        System.out.println(Weeks.weeksBetween(dateTime.withTimeAtStartOfDay(), DateTime.parse("2016-11-18 10:11:11", DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss")).withTimeAtStartOfDay()).getWeeks());
    }

    private static void print(DateTime dateTime) {
        System.out.println(DateTimeFormat.forPattern("yyyy-MM-dd hh:mm:ss").print(dateTime));
    }

}