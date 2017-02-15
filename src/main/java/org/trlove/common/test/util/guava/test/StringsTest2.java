/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: StringsTest.java
 * Author:   yichao
 * Date:    2016/10/23 下午11:02
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.CharMatcher;
import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

/**
 * StringsTest
 *
 * @author yichao
 * @date 2016/10/23
 */
public class StringsTest2 {

    public static void main(String[] args) {
        //null处理比较爽
        String empty = Strings.nullToEmpty(null);
        if(empty != null) {
            System.out.println("null to Empty not null");
        }
        String strOfNull = Strings.emptyToNull("");
        if(strOfNull == null) {
            System.out.println("empty to null");
        }

        //判空及empty:方法命名可以借鉴;判空用apache的StringUtils的isBlank或isEmpty比较多
        if(Strings.isNullOrEmpty(null) && Strings.isNullOrEmpty("")) {
            System.out.println("null or empty");
        }

        //前补位
        System.out.println(Strings.padStart("奕超", 4,'0'));


        //后补位
        System.out.println(Strings.padEnd("奕超", 4,'0'));

        //重复
        System.out.println(Strings.repeat("奕超",4));

        //相同前缀和后缀字符串
        System.out.println(Strings.commonPrefix("我是奕超","我是金贵超"));
        System.out.println(Strings.commonSuffix("我是奕超","我是金贵超"));

        //Joiner 支持链式--------------------------------------------------------------
        System.out.println("------joiner-------");
        Joiner joiner = Joiner.on(",");
        String joinStr = joiner.join("jin", "gui","chao","is", "yichao");
        System.out.println(joinStr);
        System.out.println(Joiner.on(" love ").join("yichao","randy"));
        System.out.println(Joiner.on(",").join(Lists.newArrayList(1,2,3,1,2)));
        Joiner skipNullJoiner = joiner.skipNulls();//不处理null
        System.out.println(skipNullJoiner.join("1",null,2));
        Joiner joinerUseForNull = joiner.useForNull("我是null");//特殊处理null,将null转成自己需要的
        System.out.println(joinerUseForNull.join("1",null,2));

        //Splitter 支持链式------------------------------------------------------------
        System.out.println("-----splitter-------");
        Splitter splitter = Splitter.on(",");
        System.out.println(splitter.split("a,b,,c"));
        Splitter splitterTrimResult = splitter.trimResults(); //重新new
        System.out.println(splitterTrimResult.split("a , b ,c,,d"));
        Splitter splitterOmitEmptyStrings = splitter.omitEmptyStrings();
        System.out.println(splitterOmitEmptyStrings.split("a , b ,,c"));
        Splitter splitterLimit = splitter.limit(2);//分几个
        Iterable<String> a = splitterLimit.split("a,b,c");
        List<String> list = Lists.newArrayList(a);
        System.out.println(splitterLimit.split("abc,b,c"));
        Splitter splitterPattern = Splitter.onPattern("[,|;]");//正则
        System.out.println(splitterPattern.split("a v,s;d"));
        Splitter splitterFixLength = Splitter.fixedLength(2);
        System.out.println(splitterFixLength.split("a v,s;d"));
        Splitter.MapSplitter mapSplitter = splitter.withKeyValueSeparator(";");//搞成map
        Map<String,String> mapResult = mapSplitter.split("a;b,b;c,c;d,d;e");
        System.out.println(mapResult);

        //CharMatcher---------------------
        System.out.println("------CharMatcher-----------");
        System.out.println("DIGIT start");
        CharMatcher digitMatcher = CharMatcher.DIGIT; //匹配数字
        System.out.println(digitMatcher.matchesAllOf("11"));
        System.out.println(digitMatcher.matchesAllOf("1.1"));
        System.out.println(digitMatcher.matchesAnyOf("1.1"));
        System.out.println(digitMatcher.matchesNoneOf("abc"));
        System.out.println("is matcher start");
        CharMatcher isMatcher = CharMatcher.is('a');
        System.out.println(isMatcher.matchesAnyOf("abc"));
        System.out.println(isMatcher.matchesAllOf("abc"));
        System.out.println(isMatcher.matchesNoneOf("abc"));
        System.out.println("is not matcher start");
        CharMatcher isNotMatcher = CharMatcher.isNot('a');
        System.out.println(isNotMatcher.matches('b'));
        System.out.println(isNotMatcher.matchesAllOf("ac"));
        System.out.println(isNotMatcher.matchesAnyOf("bd"));
        System.out.println(isNotMatcher.matchesNoneOf("a"));
        System.out.println("any of start");
        CharMatcher anyOf = CharMatcher.anyOf("ab");
        System.out.println(anyOf.matchesAnyOf("acd"));
        System.out.println(anyOf.matchesAllOf("ababab"));
        System.out.println(anyOf.matchesAllOf("abababc"));
        System.out.println("lower case start");
        CharMatcher lowerCaseMatcher = CharMatcher.JAVA_LOWER_CASE;
        System.out.println(lowerCaseMatcher.matchesAllOf("abc"));
        System.out.println(lowerCaseMatcher.matchesAllOf("abcD"));
    }
}
