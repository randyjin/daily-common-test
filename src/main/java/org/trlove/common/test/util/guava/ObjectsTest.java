/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: ObjectsTest.java
 * Author:   yichao
 * Date:    16/9/26 下午7:13
 * Description:
 */
package org.trlove.common.test.util.guava;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;

import java.util.Comparator;

/**
 * ObjectsTest
 *
 * @author yichao
 * @date 16/9/26
 */
public class ObjectsTest {
    public static void main(String[] args) {
        System.out.println(new ComparePerson("ma", 11).compareTo(new ComparePerson("na",10)));
        System.out.println("a".compareTo("b"));
        Ordering<String> ordering = Ordering.from(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(ordering.sortedCopy(Lists.newArrayList("a","c","b")));
    }
}
