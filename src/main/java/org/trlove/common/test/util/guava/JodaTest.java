/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JodaTest.java
 * Author:   yichao
 * Date:    16/9/28 上午9:36
 * Description:
 */
package org.trlove.common.test.util.guava;

import com.google.common.collect.Lists;
import com.google.common.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.Period;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Date;
import java.util.List;

/**
 * JodaTest
 *
 * @author yichao
 * @date 16/9/28
 */
public class JodaTest {
    public static void main(String[] args) {
    }

    private void deadDemo() {
        /*String str = "2016xx9";
        String str1 = "2016-10-7";
        DateTime dateTime = DateTime.parse(str);
        DateTime dateTime1 = DateTime.parse(str1);
        System.out.println(dateTime1.millisOfDay().withMaximumValue());
        System.out.println(dateTime.millisOfDay().withMinimumValue());
        System.out.println(dateTime.isBeforeNow());
        System.out.println(dateTime1.isAfterNow());
        DateTime d1 = new DateTime(new Date());*/
//        DateTime dateTime = DateTime.now();
//        System.out.println(dateTime.getDayOfWeek());
//        DateTime.Property pDoW = dateTime.dayOfWeek();
//        System.out.println(pDoW.getAsText());
//        System.out.println(pDoW.getAsShortText(Locale.US));
//        DateTime a = pDoW.getDateTime();
//        Instant i = a.toInstant();
//        System.out.println(i.getMillis());
//        DateTime todayStart = DateTime.now().withTimeAtStartOfDay();
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
//        DateTime dateTime = DateTime.parse("2016-11-20", formatter);
//        long timestamp = dateTime.getMillis();
//        Interval interval = new Interval(todayStart, dateTime);
//        Period period = interval.toPeriod();
//        System.out.println(period.getDays());
//        DateTime todayStart = DateTime.now().withTimeAtStartOfDay();
//        DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd");
//        DateTime dateTime = DateTime.parse("2017-11-20", formatter);
//        System.out.println(Days.daysBetween(todayStart, dateTime).getDays());
//        System.out.println(Days.daysBetween(dateTime, todayStart).getDays());
//
//
//        System.out.println(new DateTime(new Date()).millisOfDay().withMinimumValue().toDate());
//        System.out.println(new DateTime(new Date()).millisOfDay().withMaximumValue().toDate());


    }
}
