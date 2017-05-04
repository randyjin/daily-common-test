/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: LambdaTest.java
 * Author:   奕超
 * Date:    2017/3/30 下午9:06
 * Description:
 */
package org.trlove.jdk.lambda;


import com.google.common.collect.Lists;

import java.util.Comparator;
import java.util.Optional;
import org.junit.Test;

import java.util.Collections;
import java.util.List;

/**
 * LambdaTest
 *
 * @author 奕超
 * @date 2017/3/30
 */
public class LambdaTest {

    private Comparator<Integer> comparator = (o1, o2) -> Integer.compare(o1, o2);

    @Test
    public void testComparator() {
        List<Integer> integerList = Lists.newArrayList(1,3,2,6,4);
        Collections.sort(integerList, Integer::compareTo);
        List<String> stringList = Lists.newArrayList("12","wa","da","gd");
        Collections.sort(stringList, String::compareTo);
        Collections.sort(stringList, (o1, o2) -> o1.compareTo(o2));
//        stringList.forEach();
        DefaultInterface1.getFF();
    }

    @Test
    public void testRunnable() {
        Runnable r = () -> {
            for (int i=0;i<100;i++) {
                System.out.println("name" + i);
                Thread.yield();
            }
        };
        new Thread(r).start();
    }

    //调用super
    @Test
    public void testGreeter() {
        Greeter g = new ConcurrentGreeter();
        g.greet();
    }

    //调用functional接口
    @Test
    public void testFunctionalInterface() {
        System.out.println(getAge(() -> 10));
    }

    public int getAge(FunctionalInterfaceTest s) {
        return s.getAge();
    }

    //变量作用域
//    public static void repeatMessage(String text, int count) {
//        Lists.newArrayList(1,2,3).forEach(integer -> count++);
//    }

    //lambda表达式中不能修改引用的变量
}
