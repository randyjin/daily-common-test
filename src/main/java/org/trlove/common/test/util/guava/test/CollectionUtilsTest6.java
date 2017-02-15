/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: CollectionUtils.java
 * Author:   yichao
 * Date:    2016/10/25 上午9:45
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import com.google.common.math.IntMath;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * CollectionUtils
 *
 * @author yichao
 * @date 2016/10/25
 */
public class CollectionUtilsTest6 {
	public static void main(String[] args) {
		// -----------Lists--------------
		lists();

		// --------Sets---------------
		sets();

        //--------maps----------------
        maps();

        //----ImmutableMap------------
        immutableUtil();
	}

	private static void lists() {
		System.out.println("-------Lists-----------");
		List<String> list = Lists.newArrayList("I", "am", "a", "boy", "xx");
		List<List<String>> stringsList = Lists.partition(list, 2); // 分组
		System.out.println(stringsList.size());
		List<Character> charList = Lists.charactersOf("你好,haha");
		System.out.println(charList);
		// 笛卡尔积
		List<List<String>> cartesianList = Lists.cartesianProduct(
		        ImmutableList.of(ImmutableList.of("a", "b"), ImmutableList.of("c", "d")));
		System.out.println(cartesianList);
		// reverse
		List<Character> characterList = Lists.reverse(charList);
		System.out.println(characterList);

		// 处理下
		List<String> transformList = Lists.transform(list, new Function<String, String>() {
			public String apply(String input) {
				return "oo" + input;
			}
		});
		System.out.println(transformList);
	}

	private static void sets() {
		System.out.println("--------Sets-----------");
		Set<String> stringSet = Sets.newHashSet();
		System.out.println(
		        Sets.cartesianProduct(Sets.newHashSet("a", "b"), Sets.newHashSet("c", "d"), Sets.newHashSet("e", "f")));// 笛卡尔积
		System.out.println(Sets.complementOf(Lists.newArrayList(EnumTest.A, EnumTest.B, EnumTest.C)));// 不在指定的枚举里的
		System.out.println(Sets.difference(Sets.newHashSet("a", "b"), Sets.newHashSet("b", "c"))); // 返回第一个set元素不在第二个set中的数据
        System.out.println(Sets.filter(Sets.newHashSet("ab", "ac", "bc"), new Predicate<String>() {
            public boolean apply(String input) {
                return input.contains("a");
            }
        })); //自定义过滤
        System.out.println(Sets.intersection(Sets.newHashSet("a","b","c"), Sets.newHashSet("a","b","d"))); //交集
        Set<Set<String>> powerSet = Sets.powerSet(Sets.newHashSet("a","b","c")); //组合情况
        System.out.println(Sets.union(Sets.newHashSet("a","b","c"), Sets.newHashSet("a","b","d"))); //并集
    }

    private static void maps() {
        Map<String, String> map = Maps.newHashMap();
        MapDifference<String,String> differenceMap = Maps.difference(ImmutableMap.of("a","A","b","B"), ImmutableMap.of("a","A","b","c"));
        differenceMap.entriesDiffering();
        Map<String,String> common = differenceMap.entriesInCommon();
        Map<String,String> filterKeyResult = Maps.filterKeys(ImmutableMap.of("a", "A", "b", "B"), new Predicate<String>() {
            public boolean apply(String input) {
                return "b".equals(input);
            }
        });
        Map<String,String> filterEntriesResult = Maps.filterEntries(ImmutableMap.of("a", "A", "b", "B"), new Predicate<Map.Entry<String, String>>() {
            public boolean apply(Map.Entry<String, String> input) {
                return "A".equals(input.getValue());
            }
        });
        Maps.filterValues(ImmutableMap.of("a", "A", "b", "B"), new Predicate<String>() {
            public boolean apply(String input) {
                return "A".equals(input);
            }
        });
        Map<String, String> toMap = Maps.toMap(Lists.newArrayList("a", "b"), new Function<String, String>() {
            public String apply(String input) {
                return "b"+input;
            }
        });
        Map<String, String> transformValueMap = Maps.transformValues(ImmutableMap.of("a", "A", "b", "B"), new Function<String, String>() {
            public String apply(String input) {
                return "t"+input;
            }
        });
        //transformEntries,用法类似transformValues
        Properties p = new Properties();
        p.put("a","b");
        Map<String,String> propertiesMap = Maps.fromProperties(p);
        System.out.println("------");
        //通过Function和Predicate来做一些过滤及加工是非常合适的
    }

    private static void immutableUtil() {
        System.out.println("----------immutableUtil----------");
        Map<String, String> immutableMap = ImmutableMap.of("a","A","b","B");
        System.out.println(immutableMap);
        List<String> immutableList = ImmutableList.of("a","b","c");
        System.out.println(immutableList);
        BiMap<String, Integer> biMap = ImmutableBiMap.of("a",1,"b",2);
        System.out.println(biMap.inverse());
        System.out.println(biMap);
    }

}
