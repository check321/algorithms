package net.check321.algorithms.sorting.basic;

import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 希尔排序
 * @description Advanced Insertion-Sort
 * @date 2018/4/5 21:14
 */
@Component
public class ShellSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {

        int n = arrs.length;
        // 选定初始增量
        int g = 1;
        while (g < n / 3) {
            g = 3 * g + 1;
        }

        // 当增量g递减为1时，完成排序
        while (g >= 1) {
            // 以增量g为单位的Insertion-Sort
            for (int i = g; i < n; i++) {
                // 待替换元素
                Comparable e = arrs[i];
                // 元素正确排序位置
                int j = i;
                for (; j >= g && e.compareTo(arrs[j - g]) < 0; j -= g) {
                    arrs[j] = arrs[j - g];
                }
                arrs[j] = e;
            }
            // 递减增量
            g /= 3;
        }
    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {
    }

    public static void main(String[] args) {
        Integer[] arrs = {7,6,5,3,2,1,8,9};
        ShellSort shellSort = new ShellSort();
        shellSort.sort(arrs);
    }
}
