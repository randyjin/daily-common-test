/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Person.java
 * Author:   yichao
 * Date:    16/9/22 下午7:25
 * Description:
 */
package org.trlove.common.test.util.guava;

import com.google.common.base.Objects;

/**
 * Person
 *
 * @author yichao
 * @date 16/9/22
 */
public class Person implements Comparable {
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int compareTo(Object o) {
        Person person = (Person) o;
        return name.compareTo(person.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (age != person.age) return false;
        return name != null ? name.equals(person.name) : person.name == null;

    }

    @Override
    public int hashCode() {
//        int result = age;
//        result = 31 * result + (name != null ? name.hashCode() : 0);
//        return result;
        return Objects.hashCode(age, name);
    }

    @Override
    public String toString() {
        return age+name;
    }
}
