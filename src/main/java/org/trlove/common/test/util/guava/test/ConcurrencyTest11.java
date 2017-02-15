/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: ConcurrencyTest.java
 * Author:   yichao
 * Date:    2016/10/26 下午9:14
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListeningExecutorService;
import com.google.common.util.concurrent.MoreExecutors;
import org.trlove.common.test.util.guava.Task;

import java.util.List;
import java.util.concurrent.*;

/**
 * ConcurrencyTest
 *
 * @author yichao
 * @date 2016/10/26
 */
public class ConcurrencyTest11 {
	private static ListeningExecutorService executorService = MoreExecutors.listeningDecorator(
	        Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors() * 2));

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        listenableFutureTest();
        listenableFutureTest();
        futureTest();
        futureTaskTest();
    }

    private static void listenableFutureTest() throws ExecutionException, InterruptedException {
        List<ListenableFuture<?>> listenableFutureList = Lists.newArrayList();
        listenableFutureList.add(executorService.submit(new Runnable() {
            //无返回值
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("runnable");
            }
        }));
        listenableFutureList.add(executorService.submit(new Callable<String>() {
            public String call() throws Exception {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("callable");
                return "success1";
            }
        }));

        ListenableFuture<List<Object>> results = Futures.allAsList(listenableFutureList);
        for(Object obj : results.get()) {
            if(obj != null) {
                System.out.println(obj);
            }
        }
    }

    private static void futureTest() {
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        executor.shutdown();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }

    private static void futureTaskTest() {
        Task task = new Task();
        FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
        Thread thread = new Thread(futureTask);
        thread.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e1) {
            e1.printStackTrace();
        }

        System.out.println("主线程在执行任务");

        try {
            System.out.println("task运行结果"+futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println("所有任务执行完毕");
    }
}
