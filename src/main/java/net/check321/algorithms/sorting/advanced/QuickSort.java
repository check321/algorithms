package net.check321.algorithms.sorting.advanced;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title Quick-Sort 快速排序
 * @description O(nlogn)
 * @date 2018/4/7 14:57
 */
@Component
@Slf4j
public class QuickSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        sort(arrs, 0, arrs.length - 1);
    }

    /**
     * 对arrs[l...r]递归快速排序
     *
     * @param arrs
     * @param l
     * @param r
     */
    @Override
    public void sort(Comparable[] arrs, int l, int r) {

        // 递归调用返回条件
        if (l >= r) {
            return;
        }

        // 分界元素index
        int p = partition(arrs, l, r);
        this.sort(arrs, l, p - 1);
        this.sort(arrs, p + 1, r);
    }

    /**
     * 对arrs[l...r]进行partition操作，使得arrs[l...p-1] < arrs[p] < arrs[p + 1...r]
     *
     * @param arrs
     * @param l
     * @param r
     * @return p元素位置
     */
    private int partition(Comparable[] arrs, int l, int r) {
        // 元素e,做为partition操作的基准元素
        Comparable e = arrs[l];
        // 分界index也是最终e的index，使得arrs[l...j] < arrs[j] < arrs[j + 1]
        int j = l;

        for (int i = l + 1; i <= r; i++) {
            if (arrs[i].compareTo(e) < 0) {
                j++;
                commonUtils.swap(arrs, j, i);
            }
        }
        commonUtils.swap(arrs, l, j);

        return j;
    }
}
