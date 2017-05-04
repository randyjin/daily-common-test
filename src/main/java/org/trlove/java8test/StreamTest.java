/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: StreamTest.java
 * Author:   奕超
 * Date:    2017/4/20 下午2:03
 * Description:
 */
package org.trlove.java8test;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.*;
import java.util.function.UnaryOperator;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * StreamTest
 *
 * @author 奕超
 * @date 2017/4/20
 */
public class StreamTest {

    @Test
    public void testStreamFilter() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.stream().filter(s -> s.contains("a")).limit(2).count());
    }

    @Test
    public void testLimit() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.stream().filter(s -> s.contains("a")).limit(10).distinct().count());
    }

    @Test
    public void testDistinct() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.stream().distinct().count());
    }

    @Test
    public void testMax() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.stream().max(Comparator.comparing(String::length)));
    }

    @Test
    public void testFirstMatch() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.stream().filter(s -> s.length()==2).findFirst());
    }

    @Test
    public void testFindAny() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.parallelStream().filter(s -> s.length()==2).findAny());
    }

    @Test
    public void testAnyMatch() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.parallelStream().anyMatch(s -> s.length()==3));
    }

    @Test
    public void testAllMatch() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.parallelStream().allMatch(s -> s.length()<3));
    }

    @Test
    public void testNoneMatch() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e","a","bc","cd","e");
        System.out.println(a.parallelStream().noneMatch(s -> s.length()>3));
    }

    @Test
    public void testReduce() {
        List<Integer> a = Lists.newArrayList(1,2,3,4,2,3,4);
        Optional<Integer> result = a.stream().reduce((integer, integer2) -> integer+integer2);
        System.out.println(result);
        a.stream().mapToInt(value -> value).sum();
    }

    @Test
    public void testCollector() {
        List<Integer> a = Lists.newArrayList(1,2,3,4,2,3,4);
        a.stream().filter(integer -> integer>2).collect(Collectors.toList());
    }

    @Test
    public void testTreeSet() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        a.stream().collect(Collectors.joining());
    }

    @Test
    //统计
    public void testSummary() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        IntSummaryStatistics b = a.stream().collect(Collectors.summarizingInt(String::length));
    }

    @Test
    public void testJoin() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        a.stream().filter(s -> s.length()>1).collect(Collectors.joining(","));
    }

    @Test
    public void testMap() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        a.stream().collect(Collectors.toMap(String::toString, String::length));
    }

    @Test
    public void testGroupBy() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        Map b = a.stream().collect(Collectors.groupingBy(String::length));
        Map c = a.stream().collect(Collectors.groupingBy(String::length, Collectors.toSet()));
        Map d = a.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        Map e = a.stream().collect(Collectors.groupingBy(String::length, Collectors.summingInt(String::length)));
        Map f = a.stream().collect(Collectors.groupingBy(String::length, Collectors.maxBy(String::compareTo))); //还有个minBy
        System.out.println(b);
    }

    @Test
    public void testPartitionBy() {
        List<String> a = Lists.newArrayList("a","bc","cd","e","a","bc");
        Map b = a.stream().collect(Collectors.partitioningBy(s -> s.length() > 1));
        System.out.println(b);
        a.stream().filter(s -> s.length() > 10).collect(Collectors.toList());
    }

    @Test
    public void testIntStream() {
        IntStream s = IntStream.range(1,5);
        System.out.println(s.sum());
    }
}
