/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Aaa.java
 * Author:   yichao
 * Date:    2017/1/17 下午9:04
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import com.google.common.collect.*;
import org.apache.commons.collections.CollectionUtils;
import org.trlove.common.test.util.guava.Person;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * Aaa
 *
 * @author yichao
 * @date 2017/1/17
 */
public class Aaa {
    public static void main(String[] args) {
        Multimap<Integer, String> multiMap = ArrayListMultimap.create();
        multiMap.put(1,"yichao");
        multiMap.put(1,"yichao");
        multiMap.put(1,"yichao1");
        multiMap.put(2,"yichao1");
        multiMap.put(2,"yichao2");
        System.out.println(multiMap.get(1));
        List<MemberFreeCountDto> memberFreeCountDtoList = Lists.newArrayList();
        for(Integer userId : multiMap.keySet()) {
            MemberFreeCountDto memberFreeCountDto = new MemberFreeCountDto();
            memberFreeCountDto.setUserId(userId);
            Collection<String> serviceNameList = multiMap.get(userId);
            if(CollectionUtils.isEmpty(serviceNameList)) {
                continue;
            }
            Map<String, Integer> nameCountMap = Maps.newHashMap();
            for(String name : serviceNameList) {
                Integer count = nameCountMap.get(name);
                if(count == null) {
                    count = 0;
                }
                nameCountMap.put(name, count + 1);
            }
            List<FreeCountDto> freeCountDtoList = Lists.newArrayList();
            for(String name : nameCountMap.keySet()) {
                FreeCountDto freeCountDto = new FreeCountDto();
                freeCountDto.setName(name);
                freeCountDto.setCount(nameCountMap.get(name));
                freeCountDtoList.add(freeCountDto);
            }
            memberFreeCountDto.setList(freeCountDtoList);
            memberFreeCountDtoList.add(memberFreeCountDto);
            System.out.println(freeCountDtoList);;
        }
        System.out.println("hello");
    }

}
