/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Task.java
 * Author:   yichao
 * Date:    2016/10/27 下午7:41
 * Description:
 */
package org.trlove.common.test.util.guava;

import java.util.concurrent.Callable;

/**
 * Task
 *
 * @author yichao
 * @date 2016/10/27
 */
public class Task implements Callable<Integer> {

    public Integer call() throws Exception {
        System.out.println("子线程在进行计算");
            Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++)
            sum += i;
        return sum;
    }
}
