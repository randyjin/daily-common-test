/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Primitives.java
 * Author:   yichao
 * Date:    2016/10/26 下午8:12
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.primitives.Ints;
import com.google.common.primitives.UnsignedInts;

/**
 * Primitives
 *
 * @author yichao
 * @date 2016/10/26
 */
public class Primitives10 {
    public static void main(String[] args) {
        System.out.println(Ints.max(1,4,2));
        System.out.println(Ints.min(1,4,2));
        System.out.println(Ints.tryParse("q"));
        System.out.println(Ints.tryParse("1"));
        System.out.println(Ints.stringConverter().convert("1"));
//        System.out.println(Ints.stringConverter().convert("3a"));
        //Shorts,Longs,Doubles等基本类型都对应,api基本类似
        System.out.println(UnsignedInts.parseUnsignedInt("1"));
//        System.out.println(UnsignedInts.parseUnsignedInt("-1"));
    }
}
