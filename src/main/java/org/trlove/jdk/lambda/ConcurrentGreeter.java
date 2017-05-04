/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: ConcurrentGreeter.java
 * Author:   奕超
 * Date:    2017/4/1 下午5:00
 * Description:
 */
package org.trlove.jdk.lambda;

/**
 * ConcurrentGreeter
 *
 * @author 奕超
 * @date 2017/4/1
 */
public class ConcurrentGreeter extends Greeter {

    @Override
    public void greet() {
        Thread t = new Thread(super::greet);
        t.start();
    }
}
