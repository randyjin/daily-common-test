/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: JoddBeanUtil.java
 * Author:   yichao
 * Date:    2016/11/11 下午7:56
 * Description:
 */
package org.trlove.common.test.util.jodd;

import jodd.bean.BeanUtil;

/**
 * JoddBeanUtil
 *
 * @author yichao
 * @date 2016/11/11
 */
public class JoddBeanUtil {

    public static void main(String[] args) {
        Company company = new Company();
        BeanUtil.setProperty(company, "logo", "hello,logo");

    }
}
