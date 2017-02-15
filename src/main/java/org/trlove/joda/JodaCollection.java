/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JodaPrimitive.java
 * Author:   yichao
 * Date:    2016/11/8 下午7:52
 * Description:
 */
package org.trlove.joda;


import org.joda.collect.grid.DenseGrid;
import org.joda.collect.grid.Grid;
import org.trlove.common.test.util.guava.Person;

import java.lang.instrument.Instrumentation;

/**
 * JodaPrimitive
 *
 * @author yichao
 * @date 2016/11/8
 */
public class JodaCollection {
    public static void main(String[] args) {
//        ArrayIntCollection arrayIntCollection = new ArrayIntCollection();
        Grid<Person> personGrid = DenseGrid.create(2,5);
        personGrid.put(0,1,new Person(1,"name"));
        System.out.println(personGrid);
        System.out.println(personGrid.columnCount());
        System.out.println(personGrid.contains(1,2));
        System.out.println();
    }
}
