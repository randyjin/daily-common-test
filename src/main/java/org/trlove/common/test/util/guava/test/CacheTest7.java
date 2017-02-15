/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: CacheTest.java
 * Author:   yichao
 * Date:    2016/10/26 下午8:56
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * CacheTest
 *
 * @author yichao
 * @date 2016/10/26
 */
public class CacheTest7 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder().maximumSize(10).expireAfterWrite(1, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
            @Override
            public String load(String key) throws Exception {
                System.out.println("没缓存");
//                return "key"+111;
                Thread.sleep(5000);
                throw new Exception("fuck");
//                return null;
            }
        });
        for(int i=0;i< 10000;i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("hello");
                        loadingCache.get("你好");
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

//        System.out.println(loadingCache.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache.get("你好"));
//        LoadingCache<String, String> loadingCache1 = CacheBuilder.newBuilder().maximumSize(10).expireAfterAccess(1, TimeUnit.SECONDS).build(new CacheLoader<String, String>() {
//            @Override
//            public String load(String key) throws Exception {
//                System.out.println("no cache");
//                return "key"+111;
//            }
//        });
//        System.out.println(loadingCache1.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache1.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache1.get("你好"));
//        Thread.sleep(500);
//        System.out.println(loadingCache1.get("你好"));
//        loadingCache1.invalidate("你好");
//        System.out.println(loadingCache1.get("你好"));
    }
}
