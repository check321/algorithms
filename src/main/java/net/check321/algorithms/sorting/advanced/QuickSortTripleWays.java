package net.check321.algorithms.sorting.advanced;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import net.check321.algorithms.sorting.basic.InsertionSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


/**
 * @author check321
 * @title 三路快速排序
 * @description [l ... lt] < [lt + 1 ... gt - 1] < [gt - r]
 * @date 2018/4/9 21:38
 */
@Slf4j
@Component
public class QuickSortTripleWays extends BaseSortable implements Sortable {

    @Autowired
    private InsertionSort insertionSort;

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        sort(arrs,0,arrs.length - 1);
    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {
        if (r - l<= 15) {
            insertionSort.sort(arrs, l, r);
            return;
        }

        // partition
//        commonUtils.swap(arrs, randomInRange(l,r), l);

        // 标定点
        Comparable e = arrs[l];
        // [l + 1 ... lt]
        int lt = l;
        // [gt ... r]
        int gt = r + 1;
        // cursor
        int i = l + 1;

        while (i < gt) {
            if (arrs[i].compareTo(e) < 0) {
                commonUtils.swap(arrs, i, lt + 1);
                lt++;
                i++;
            } else if (arrs[i].compareTo(e) > 0) {
                commonUtils.swap(arrs, i, gt - 1);
                gt--;
            } else {
                i++;
            }
        }

        commonUtils.swap(arrs, l, lt);

        sort(arrs, l, lt - 1);
        sort(arrs, gt, r);
    }
}
