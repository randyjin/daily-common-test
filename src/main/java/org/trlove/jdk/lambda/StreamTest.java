/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: StreamTest.java
 * Author:   奕超
 * Date:    2017/4/6 下午7:53
 * Description:
 */
package org.trlove.jdk.lambda;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.math.BigDecimal;
import java.nio.file.Files;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * StreamTest
 *
 * @author 奕超
 * @date 2017/4/6
 */
public class StreamTest {

    @Test
    public void testTry(){
        List<String> sss = Lists.newArrayList("21","fe","jf");
        System.out.println(StringUtils.join(sss, ","));
        Map<Integer, List<String>> a = sss.stream().collect(Collectors.groupingBy(String::length)); //Collectors.maxBy()
        System.out.println(a);
        int[] vals = {1,2,4,8};
        Stream.of(vals);
        Integer[] valss = {1,2,4,8};
        Stream.of(valss);
    }
}
