package org.trlove;

import org.trlove.common.test.util.SortTypeEnum;
import org.trlove.common.test.util.SortUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    public static void main(String[] args) {
        List<Long> originList = new ArrayList<Long>();
        for (int index = 0; index < 100000; index++) {
            originList.add((long) (Math.random() * 9000));
        }
        Long current = System.currentTimeMillis();
        SortUtil.sort(originList, new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        }, SortTypeEnum.快速排序);
        System.out.println(System.currentTimeMillis() - current);
        originList.clear();
        for (int index = 0; index < 100000; index++) {
            originList.add((long) (Math.random() * 9000));
        }
        current = System.currentTimeMillis();
        Collections.sort(originList, new Comparator<Long>() {
            public int compare(Long o1, Long o2) {
                if (o1 > o2) {
                    return -1;
                } else if (o1 < o2) {
                    return 1;
                }
                return 0;
            }
        });
        System.out.println(System.currentTimeMillis() - current);
    }
}
