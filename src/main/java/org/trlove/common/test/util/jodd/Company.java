/*
 * Copyright (C), 2014-2015, 杭州小卡科技有限公司
 * FileName: Company.java
 * Author:   yichao
 * Date:    2016/11/11 下午7:59
 * Description:
 */
package org.trlove.common.test.util.jodd;

/**
 * Company
 *
 * @author yichao
 * @date 2016/11/11
 */
public class Company {

    private String logo;

    private String name;

    public Company(String logo, String name) {
        this.logo = logo;
        this.name = name;
    }

    public Company() {
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }
}
