/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: OrderingTest.java
 * Author:   yichao
 * Date:    16/9/22 下午7:18
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.apache.commons.collections.CollectionUtils;
import org.trlove.common.test.util.guava.Person;

import java.util.Comparator;
import java.util.List;

/**
 * OrderingTest
 *
 * @author yichao
 * @date 16/9/22
 */
public class OrderingTest3 {

	public static void main(String[] args) {
	    //自定义comparator
//        Ordering<Person> diyOrdering = Ordering.from(new Comparator<Person>() {
//            public int compare(Person o1, Person o2) {
//                return new Integer(o1.getAge()).compareTo(o2.getAge());
//            }
//        });
//        print(diyOrdering.max(Lists.newArrayList(new Person(10,"333"), new Person(11,"444"))));
//
//	    // natural ordering
//        System.out.println("-----natural-------");
//        Ordering<Person> naturalOrdering = Ordering.natural();
//        print(naturalOrdering.max(Lists.newArrayList(new Person(1,"xx"))));
//        List<Person> xxx = buildPerson();
//        List<Person> naturalPersonList = naturalOrdering.sortedCopy(xxx);
//        printList(naturalPersonList);
//        System.out.println("-------");
//        printList(naturalOrdering.reverse().sortedCopy(buildPerson()));
//        System.out.println("-------");
//        print(naturalOrdering.min(buildPerson()));
//        System.out.println("-------");
//        print(naturalOrdering.max(buildPerson()));
//        System.out.println("-------");
//        printList(naturalOrdering.leastOf(buildPerson(), 2)); //最后两个
//        System.out.println("-------");
//        printList(naturalOrdering.greatestOf(buildPerson(), 2)); //最前面的2个
//        System.out.println("-------");
//        System.out.println(naturalOrdering.isOrdered(buildPerson()));
//        System.out.println("-------");
//        System.out.println(naturalOrdering.binarySearch(buildPerson(), new Person(27,"yichao")));
//        System.out.println("------------");
        //explicit,指定顺序,比如List<字符串>顺序等
        System.out.println("----explicit---------");
        Ordering<Person> explicitOrdering = Ordering.explicit(buildPerson()).nullsFirst();
        List<Person> ordered = explicitOrdering.sortedCopy(buildPersonOther());
        printList(explicitOrdering.sortedCopy(buildPersonOther()));
        //usingToString 根据toString排序
//        System.out.println("------usingToString---------");
//        Ordering usingToString = Ordering.usingToString();
//        printList(usingToString.sortedCopy(buildPerson()));
//        //compound(Comparator):先根据原有的排序排,将comparator作为第二排序规则
//        //nullsFirst,nullsLast
//        System.out.println("----------------");
//        testNaturalInteger();
    }

	static List<Person> buildPerson() {
		return Lists.newArrayList(new Person(1, "peiyao"), new Person(27, "yichao"), new Person(1, "jlcky"),
		        new Person(2, "jimmy"));
	}

	static List<Person> buildPersonOther() {
		return Lists.newArrayList(new Person(27, "yichao"),null, new Person(1, "peiyao"),
		        new Person(2, "jimmy"));
	}

	static void printList(List<Person> personList) {
	    if(CollectionUtils.isEmpty(personList)) {
	        return;
        }
        for(Person person : personList) {
            if(null == person) {
                System.out.println("null");
            } else {
                System.out.println(person.getName() + ":" + person.getAge());
            }
        }
    }

    static void print(Person person) {
        System.out.println(person.getName() + ":" + person.getAge());
    }

    static void testNaturalInteger() {
        List<Integer> integers = Lists.newArrayList(3,4,1,32,23);
        Ordering<Integer> ordering = Ordering.natural();
        System.out.println(ordering.max(integers));
    }

}
