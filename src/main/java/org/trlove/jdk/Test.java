/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Test.java
 * Author:   yichao
 * Date:    2016/11/5 下午6:18
 * Description:
 */
package org.trlove.jdk;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import org.trlove.common.test.util.guava.Person;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Test
 *
 * @author yichao
 * @date 2016/11/5
 */
public class Test {

	public static void main(String[] args) {

		lambdaTest();
	}

	private static void lambdaTest() {
		BigDecimal subResult = new BigDecimal("2.34").subtract(new BigDecimal("1.23"));
		System.out.println(subResult.doubleValue());
		// 所有只有一个抽象方法的接口都是函数式接口
		// 重载方法时,会进行多态匹配
		Comparator<Integer> integerComparator = (i1, i2) -> Integer.compare(i1, i2);
		Comparator<String> stringComparator = String::compareToIgnoreCase;
		String[] a = new String[] { "a", "c", "b" };
		Arrays.sort(a, String::compareToIgnoreCase);// 方法引用,对象::实例方法,类::静态方法,类::实例方法;这种方式代码更加简洁;
		System.out.println(Lists.newArrayList(a));
		// 被引用的变量是不能修改的
		// 自定义lambda
		LambdaInterface l = (i1, i2) -> i1 - i2;
		List<Integer> intList = Lists.newArrayList(1,2,3,4);
		Collections.shuffle(intList);
		intList.forEach(System.out::print); // default方法
		//default方法:类优先原则,当父类和接口有相同的方法,则会父类的优先

	}

//	private static void aa(int a) {
//	    Runnable runnable = () -> {a--};
//    }

	private static void withOutLambdaTest() {
		Comparator<Integer> integerComparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o1, o2);
			}
		};
		Comparator<String> stringComparator = new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareToIgnoreCase(o2);
			}
		};
		String[] a = new String[] { "a", "c", "b" };
		Arrays.sort(a, stringComparator);
	}
}
