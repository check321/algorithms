package net.check321.algorithms.sorting.basic;

import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

/**
* @title 选择排序 O(n^2)
* @description
* @author check321
* @date 2018/4/5 23:26
*/
@Component
public class SelectionSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {

        // 待排序元素
        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            // 遍历所有后继元素
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j].compareTo(arrs[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            commonUtils.swap(arrs,i,minIndex);
        }

    }
}
