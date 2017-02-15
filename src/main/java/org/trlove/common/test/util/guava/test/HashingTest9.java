/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: HashingTest.java
 * Author:   yichao
 * Date:    2016/10/26 下午8:27
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.hash.HashFunction;
import com.google.common.hash.Hashing;

import java.nio.charset.Charset;

/**
 * HashingTest
 *
 * @author yichao
 * @date 2016/10/26
 */
public class HashingTest9 {
    public static void main(String[] args) {
        //提供各种hash算法
        HashFunction md5 = Hashing.md5();
        System.out.println(md5.hashString("nihao", Charset.forName("utf-8")));
        HashFunction sha1 = Hashing.sha1();
    }
}
