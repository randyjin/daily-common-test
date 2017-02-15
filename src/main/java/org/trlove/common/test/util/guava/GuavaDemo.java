/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: GuavaDemo.java
 * Author:   yichao
 * Date:    16/9/13 下午7:41
 * Description:
 */
package org.trlove.common.test.util.guava;


import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multimaps;
import com.google.common.collect.Sets;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;


/**
 * GuavaDemo
 *
 * @author yichao
 * @date 16/9/13
 */
@GwtCompatible
public final class GuavaDemo {
    public static void main(String[] args) {
        System.out.println(NumberUtils.isDigits("11"));
        System.out.println(NumberUtils.isDigits("11.1"));
        Optional<String> optional = Optional.absent();
//        Absent.absent();
        Optional<String> op1 = Optional.of("abc");
        if(op1.isPresent()) {

        }
        Optional<Integer> op2 = op1.transform(new Function<String, Integer>() {
            public Integer apply(String input) {
                return input.length();
            }
        });
        System.out.println(op2.get());
        System.out.println(Strings.nullToEmpty(null));
        System.out.println(Strings.padStart("111",5,'0'));
        System.out.println(Strings.padStart("11111",5,'0'));
        System.out.println(Strings.padStart("111111",5,'0'));
        System.out.println(Strings.repeat("12",4));
        System.out.println(Strings.commonPrefix("1234", "1243"));
        System.out.println(Strings.commonPrefix("01234", "1243"));
        System.out.println(Strings.commonSuffix("1243", "12143"));
        Preconditions.checkArgument(true);
    }


}
