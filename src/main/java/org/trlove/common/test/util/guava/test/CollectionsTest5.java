/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: CollectionsTest.java
 * Author:   yichao
 * Date:    16/9/26 下午8:05
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.*;
import org.trlove.common.test.util.guava.Person;

import java.util.List;
import java.util.Set;

/**
 * CollectionsTest
 *
 * @author yichao
 * @date 16/9/26
 */
public class CollectionsTest5 {
    public static void main(String[] args) {
        Set<String> set = ImmutableSet.of("a","c","b","c");
        System.out.println(set);
        Set<Person> personSet = ImmutableSet.of(new Person(1,"2"));
        Person person = personSet.iterator().next();
        person.setAge(2);

        ImmutableSet<Person> persons =
                ImmutableSet.<Person>builder()
                        .add(new Person(15, "xxx"))
                        .build();
        System.out.println(persons.size());
        System.out.println("==============");
        multiSet();
        multiMap();
        biMap();
        table();
        rangeSet();
        rangeMap();
        collections2();
    }

    static void multiSet() {
        //map和set的结合体
        System.out.println("--------multiSet------------");
        Multiset<String> multiset = HashMultiset.create();
        multiset.add("a");
        multiset.add("b");
        multiset.add("a",2);
        multiset.add("d");
        multiset.add("d");
        multiset.add("c");
        multiset.add("g");
        multiset.remove("a");
        System.out.println(multiset.elementSet());
        System.out.println(multiset.size());
        for(String key : multiset.elementSet()) {
            System.out.println(multiset.count(key));
        }
        for(Multiset.Entry entry : multiset.entrySet()) {
            System.out.print(entry.getElement());
            System.out.println(entry.getCount());
        }
    }

    static void collections2() {
        System.out.println("--------collections2------------");
        List<String> filterList = Lists.newArrayList(Collections2.filter(Lists.newArrayList("ab", "bc"), new Predicate<String>() {
            public boolean apply(String input) {
                return input.contains("a");
            }
        }));
        System.out.println(filterList);
    }

    static void multiMap() {
        System.out.println("--------multiMap------------");
        Multimap<String, Person> multiMap = HashMultimap.create();
        multiMap.put("a", new Person(1,"21"));
        multiMap.put("a", new Person(1,"21"));
        multiMap.put("a", new Person(2,"24"));
        System.out.println(multiMap.get("a"));
        System.out.println(multiMap.size());
        Multimap<String, Person> multiMap1 = ArrayListMultimap.create();
        multiMap1.put("a", new Person(1,"21"));
        multiMap1.put("a", new Person(1,"21"));
        multiMap1.put("a", new Person(2,"24"));
        multiMap1.put("b", new Person(2,"24"));
        System.out.println(multiMap1.get("a"));
        System.out.println(multiMap1.size());

    }

    static void biMap() {
        System.out.println("--------biMap------------");
        BiMap<String, Integer> a = HashBiMap.create();
        //局限性:不能有value相同的entry
        a.put("a", 1);
        System.out.println(a.inverse().get(1));
    }

    static void table() {
        System.out.println("--------table------------");
        Table<String, String, Person> table = HashBasedTable.create();
        table.put("jin","guichao", new Person(1,"2"));
        table.put("jin","guixx", new Person(1,"2"));
        table.put("wang","guichao", new Person(1,"2"));
        table.put("wang","guixx", new Person(1,"2"));
        System.out.println(table.column("guichao"));
        System.out.println(table.row("jin"));
    }

//    static void classToInstanceMap() {
//        ClassToInstanceMap<Person> classToInstanceMap = MutableClassToInstanceMap.create();
//        classToInstanceMap.put(Person.class, new Person(10,"ws"));
//    }

    static void rangeSet() {
        System.out.println("--------rangeSet------------");
        RangeSet<Integer> rangeSet = TreeRangeSet.create();
        rangeSet.add(Range.closed(1,10));
        rangeSet.add(Range.closedOpen(9, 19));
        System.out.println(rangeSet.contains(5));
        System.out.println(rangeSet.contains(18));
        System.out.println(rangeSet.contains(19));
        System.out.println(rangeSet.encloses(Range.closed(2,10)));
    }

    static void rangeMap() {
        System.out.println("--------rangeMap------------");
        RangeMap<EnumTest, String> rangeMap = TreeRangeMap.create();
        rangeMap.put(Range.closed(EnumTest.A, EnumTest.C), "你好");
        System.out.println(rangeMap.get(EnumTest.D));
        System.out.println(rangeMap.get(EnumTest.B));
        Predicate<Person> personPredicate = Predicates.compose(Range.closed(1, 4), new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getAge();
            }
        });
        System.out.println(personPredicate.apply(new Person(3,"randy")));
    }
}
