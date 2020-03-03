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
import org.apache.commons.lang3.StringUtils;

import java.util.Comparator;

/**
 * ObjectsTest
 *
 * @author yichao
 * @date 16/9/26
 */
public class ObjectsTest {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        System.out.println(new ComparePerson("ma", 11).compareTo(new ComparePerson("na",10)));
        System.out.println("a".compareTo("b"));
        Ordering<String> ordering = Ordering.from(new Comparator<String>() {
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println(ordering.sortedCopy(Lists.newArrayList("a","c","b")));
        System.out.println(Person.class.getName());
        System.out.println(Person.class.getTypeName());
        System.out.println(Person.class.getCanonicalName());
        System.out.println(Person.class.getSimpleName());
        System.out.println(int.class.getName());
        System.out.println(int[].class.getName());
        System.out.println(Person.class.getClass().getClass().getClass().getClass());
        Person person = Person.class.newInstance();
        System.out.println(person);
        String[] v = "3.4.5".split(".");
        System.out.println(v);
        v = StringUtils.split("3.4.5", ".");
        System.out.println(v);
    }
}
