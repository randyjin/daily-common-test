/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: MemberFreeCountDto.java
 * Author:   yichao
 * Date:    2017/1/18 上午10:01
 * Description:
 */
package org.trlove.common.test.util.guava.test;

import java.util.List;

/**
 * MemberFreeCountDto
 *
 * @author yichao
 * @date 2017/1/18
 */
public class MemberFreeCountDto {

    private Integer userId;

    private List<FreeCountDto> list;

    public List<FreeCountDto> getList() {
        return list;
    }

    public void setList(List<FreeCountDto> list) {
        this.list = list;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
