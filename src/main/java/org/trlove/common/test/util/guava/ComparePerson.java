/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: ComparePerson.java
 * Author:   yichao
 * Date:    16/9/26 下午7:25
 * Description:
 */
package org.trlove.common.test.util.guava;

import com.google.common.collect.ComparisonChain;

/**
 * ComparePerson
 *
 * @author yichao
 * @date 16/9/26
 */
public class ComparePerson implements Comparable<ComparePerson> {
    private String name;
    private int age;

    public ComparePerson(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int compareTo(ComparePerson c) {
        return ComparisonChain.start().compare(name, c.getName()).compare(age, c.getAge()).result();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
