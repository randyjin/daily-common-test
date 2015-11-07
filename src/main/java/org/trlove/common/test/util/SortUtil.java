package org.trlove.common.test.util;

import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.Comparator;
import java.util.List;

public class SortUtil {

    public static <T> void sort(List<T> originList, Comparator<T> comparator, SortTypeEnum sortType) {
        if (SortTypeEnum.快速排序.equals(sortType)) {
            List<T> result = quickSort(originList, comparator);
            if(CollectionUtils.isNotEmpty(result)) {
                originList.clear();
                for(int index = 0; index < result.size(); index++) {
                    originList.add(index, result.get(index));
                }
            }
        }
    }

    private static <T> List<T> quickSort(List<T> originList, Comparator<T> comparator) {
        if (CollectionUtils.isNotEmpty(originList) && null != comparator) {
            if (originList.size() == 1) {
                return originList;
            }
            List<T> result = Lists.newArrayList();
            T index = originList.get(0);
            List<T> left = Lists.newArrayList();
            List<T> right = Lists.newArrayList();
            originList.remove(0);
            for (T element : originList) {
                if (comparator.compare(element, index) >= 0) {
                    left.add(element);
                } else {
                    right.add(element);
                }
            }
            if (CollectionUtils.isNotEmpty(left)) {
                if (left.size() > 1) {
                    result.addAll(quickSort(left, comparator));
                } else {
                    result.add(left.get(0));
                }
            }
            result.add(index);
            if (CollectionUtils.isNotEmpty(right)) {
                if (right.size() > 1) {
                    result.addAll(quickSort(right, comparator));
                } else {
                    result.add(right.get(0));
                }
            }
            return result;
        }
        return null;
    }

}
