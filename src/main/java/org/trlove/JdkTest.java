/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JdkTest.java
 * Author:   yichao
 * Date:    16/9/28 下午9:47
 * Description:
 */
package org.trlove;

import com.google.common.collect.Lists;
import org.trlove.common.test.util.guava.Person;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Stream;

/**
 * JdkTest
 *
 * @author yichao
 * @date 16/9/28
 */
public class JdkTest {
    public static void main(String[] args){
        testRegex("hshs ja-y*");
    }

    private static void testRegex(String org) {
//        System.out.println(org.matches("[\\w|*|\\-|\\s]{0,32}"));
//        System.out.println("aafaac".matches("^a\\w{4}c$"));
//        System.out.println("1dfs".matches("\\d.*"));
//        System.out.println("hello world,hello cat".matches("\\bhello\\b.*\\bhello.*"));
//        System.out.println("\n".matches("\n"));
//        System.out.println("a_1_".matches("\\w*"));
//        System.out.println("1233".matches("\\d*"));
//        System.out.println("11111".matches("1*"));
//        System.out.println("11111".matches("1+"));
//        System.out.println("11111".matches("1111?"));
//        System.out.println("11111".matches("1{5}"));
//        System.out.println("11111".matches("1{4,}"));
//        System.out.println("11111".matches("1{4,7}"));
//        System.out.println("aeio".matches("[aeiou]*"));
//        System.out.println("(010)92832482".matches("\\(0\\d{2}\\)\\d{8}|0\\d{2}-?\\d{8}"));
//        System.out.println("010-92832482".matches("\\(0\\d{2}\\)\\d{8}|0\\d{2}-?\\d{8}"));
//        System.out.println("010020".matches("((010)|(020))+"));
//        System.out.println("go gogo".matches("\\b(\\w+)\\b\\s+\\1\\1\\b"));
////        BigDecimal a = new BigDecimal("0.00").intValue();
//        Integer a = new BigDecimal("0.00").intValue();
//
//        System.out.println(a.equals(BigDecimal.ZERO.intValue()));

        List<String> aStrList = Lists.newArrayList("a","c","d");
        List<String> bStrList = Lists.newArrayList("a","d");
        aStrList.retainAll(bStrList);
        System.out.println(aStrList);
        Stream<String> words = Stream.of("a,b,c".split("[\\\\P{L}]"));
        String[] xxx = "a,b,c".split("[\\\\P{L}]");
        System.out.println(words);
    }
}
