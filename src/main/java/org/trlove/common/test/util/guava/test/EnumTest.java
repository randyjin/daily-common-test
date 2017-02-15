package org.trlove.common.test.util.guava.test;

import java.util.Comparator;

/**
 * Created by aguda on 2016/10/25.
 */
public enum EnumTest implements Comparator<EnumTest> {
    A("1"),
    B("21"),
    C("5"),
    D("3");

    private String code;

    EnumTest(String code) {
        this.code = code;
    }

    private String getCode() {
        return code;
    }

    public int compare(EnumTest o1, EnumTest o2) {
        return o1.getCode().compareTo(o2.getCode());
    }
}
