/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Jdk8Test.java
 * Author:   yichao
 * Date:    2016/12/21 下午7:40
 * Description:
 */
package org.trlove.jdk;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import org.apache.commons.lang3.StringUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Jdk8Test
 *
 * @author yichao
 * @date 2016/12/21
 */
public class Jdk8Test {

    public static void main(String[] args) {
        Map<String,String> a = ImmutableMap.of("key1", StringUtils.join(Lists.newArrayList("a","b","c"), ","), "key2","value2");
        for (String s : a.keySet()) {
            System.out.println(s);
            System.out.println(a.get(s));
        }
        System.out.println(Lists.newArrayList("hello","nihao").stream().limit(1).collect(Collectors.toList()));
        System.out.println(Lists.newArrayList("hello","nihao").stream().skip(1).collect(Collectors.toList()));
        Lists.newArrayList("hello","nihao").stream().forEach(s -> System.out.println(s));
        
        List<String> haha = Lists.newArrayList();
        System.out.println(Lists.newArrayList("hello","nihao").stream().peek(s -> haha.add(s.toUpperCase())).collect(Collectors.toList()));
        System.out.println(haha);
//        Lists.newArrayList("hello","nihao").stream().filter()
//        Stream.of()
    }
}
