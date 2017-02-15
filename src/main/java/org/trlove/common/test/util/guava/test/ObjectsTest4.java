/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: ObjectsTest.java
 * Author:   yichao
 * Date:    2016/10/24 下午10:49
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.Objects;
import org.trlove.common.test.util.guava.ComparePerson;

/**
 * ObjectsTest
 *
 * @author yichao
 * @date 2016/10/24
 */
public class ObjectsTest4 {

    public static void main(String[] args) {
        System.out.println(Objects.equal("1", null));
        System.out.println(Objects.equal(null, null));
        System.out.println(new ComparePerson("ma", 11).compareTo(new ComparePerson("na",10)));//比较器
    }
}
