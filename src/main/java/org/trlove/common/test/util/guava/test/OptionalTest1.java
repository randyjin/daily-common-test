/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: OptionalTest.java
 * Author:   yichao
 * Date:    2016/10/23 下午10:40
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import org.trlove.common.test.util.guava.Person;


/**
 * OptionalTest
 *
 * @author yichao
 * @date 2016/10/23
 */
public class OptionalTest1 {


    /**
     * 主要用isPresent来代替null判断,最常用的是isPresent()和get(),以及fromNullable
     * Optional抽象类有两个子类:Present(有值)和Absent(无值),of得到的是present,absent得到Absent
     * @param args
     */
    public static void main(String[] args) {
        Optional<Person> personOptional = Optional.of(new Person(10, "奕超"));
        Optional<Person> absentPerson = Optional.absent();
        System.out.println(absentPerson.or(new Person(20, "randy")).getAge());
        Optional<Person> optionalNullable = Optional.fromNullable(null);
        if(!optionalNullable.isPresent()){
            System.out.println("optionalNullable");
        }
        if(personOptional.isPresent()) {
            System.out.println(personOptional.get().getAge());
        }
        //transform转化
        Optional<Integer> ageOptional = personOptional.transform(new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getAge();
            }
        });
        System.out.println(ageOptional.get());

        Optional<Integer> ageNullOptional = absentPerson.transform(new Function<Person, Integer>() {
            public Integer apply(Person input) {
                return input.getAge();
            }
        });
        System.out.println(ageNullOptional.isPresent());
    }
}
