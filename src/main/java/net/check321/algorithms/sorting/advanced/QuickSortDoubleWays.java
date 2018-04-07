package net.check321.algorithms.sorting.advanced;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 双路快速排序
 * @description O(nlogn) 左右两边分别partition 平衡整个数组分治结构
 * @date 2018/4/7 18:22
 */
@Component
@Slf4j
public class QuickSortDoubleWays extends BaseSortable implements Sortable {

    @Autowired
    @Qualifier("insertionSort")
    private Sortable insertionSort;

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        this.sort(arrs, 0, arrs.length - 1);
    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {
        if( r - l <= 15 ){
            insertionSort.sort(arrs, l, r);
            return;
        }

        int p = partition(arrs, l, r);
        this.sort(arrs, l, p - 1);
        this.sort(arrs, p + 1, r);
    }

    /**
     * 返回标定点坐标p 并排序数组 ： arrs[l...p - 1] < arrs[p] < arrs[p + 1 ...r]
     *
     * @param arrs
     * @param l
     * @param r
     * @return
     */
    private int partition(Comparable[] arrs, int l, int r) {
        // 随机标定点，预防在近乎有序的数组排序场景下Quick-Sort因为标定点的不平衡导致性能退化为O(n^2).
        commonUtils.swap(arrs, l, randomInRange(l, r));

        // 标定点元素e
        Comparable e = arrs[l];
        // 左路起始index，从标定点下一位开始一直往后遍历
        int i = l + 1;
        // 右路起始index，从数组尾部开始一直往前遍历
        int j = r;

        while (true) {
            // 左路 < 标定点e , 继续向后遍历
            while (i <= r && arrs[i].compareTo(e) < 0) {
                i++;
            }

            // 右路 > 标定点e , 继续向前遍历
            while (j >= l + 1 && arrs[j].compareTo(e) > 0) {
                j--;
            }

            // 循环退出标记
            if (i > j) {
                break;
            }

            // 将不符合左右路排序规则的元素交换
            commonUtils.swap(arrs, i, j);
            i++;
            j--;
        }

        // 最终将标定点e与i交换
        commonUtils.swap(arrs, l, j);
        return j;
    }
}
