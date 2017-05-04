/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: DefaultInterface1.java
 * Author:   yichao
 * Date:    2016/11/21 下午7:28
 * Description:
 */
package org.trlove.jdk.lambda;

/**
 * DefaultInterface1
 *
 * @author yichao
 * @date 2016/11/21
 */
public interface DefaultInterface1 {
    default int getAge() {
        return 1;
    }

    static int getFF() {
        return 100;
    }
}
