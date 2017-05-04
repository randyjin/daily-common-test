/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: TimeTest.java
 * Author:   奕超
 * Date:    2017/4/20 下午7:38
 * Description:
 */
package org.trlove.java8test;

import org.junit.Test;

import java.time.*;
import java.time.temporal.TemporalAdjusters;

/**
 * TimeTest
 *
 * @author 奕超
 * @date 2017/4/20
 */
public class TimeTest {

    @Test
    public void testInstant() {
        Instant instant = Instant.MIN;
        Duration duration = Duration.between(instant, Instant.MAX);
        duration.getSeconds();
        duration.toDays();
        LocalDate localDate = LocalDate.of(2014,1,1).plusDays(255);
        System.out.println(localDate.toString());
        LocalDate firstSaturday = localDate.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY));
        System.out.println(firstSaturday.toString());
        LocalTime localTime = LocalTime.of(10,10);
        System.out.println(localTime.toString());
//        LocalDateTime localDateTime = LocalDateTime.of
        LocalDateTime birth = LocalDateTime.of(1989,11,28,0,0,0);
        System.out.println(Duration.between(birth,LocalDateTime.now()).toDays());
    }
}
