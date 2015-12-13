package org.trlove.common.test.util;

/**
 * Created by guichao.jgc on 2015/11/7.
 */
public enum SortTypeEnum {

    快速排序("quickSort"),
    堆排序("heapSort"),
    归并排序("mergeSort");

    private String code;

    SortTypeEnum(String code){
        this.code = code;
    }

    public String code() {
        return code;
    }

}
