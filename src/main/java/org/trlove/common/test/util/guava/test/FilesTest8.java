/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: FilesTest.java
 * Author:   yichao
 * Date:    2016/10/26 下午8:19
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.base.Predicate;
import com.google.common.io.Closer;
import com.google.common.io.Files;

import java.io.File;

/**
 * FilesTest
 *
 * @author yichao
 * @date 2016/10/26
 */
public class FilesTest8 {
    //简化一些文件读写操作;基本功能跟apache的差不多
    public static void main(String[] args) {
        Predicate<File> directoryPredicate = Files.isDirectory();
        Predicate<File> filePredicate = Files.isFile();
        System.out.println(Files.getFileExtension("a.b.c"));
        System.out.println(Files.getNameWithoutExtension("a.b.c"));
//        Files.readLines();
//        Files.move();
//        Files.copy();
        //可以register多个流,然后一次性关闭;
        Closer closer = Closer.create();
//        closer.register() //注册流信息
//        closer.close();
    }
}
