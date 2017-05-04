/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: DefaultInterfaceImpl.java
 * Author:   奕超
 * Date:    2017/3/31 上午11:50
 * Description:
 */
package org.trlove.jdk.lambda;

/**
 * DefaultInterfaceImpl
 *
 * @author 奕超
 * @date 2017/3/31
 */
public class DefaultInterfaceImpl implements DefaultInterface1,DefaultInterface2 {
    @Override
    public int getAge() {
        return 0;
    }
}
//默认方法遵循类优先原则
