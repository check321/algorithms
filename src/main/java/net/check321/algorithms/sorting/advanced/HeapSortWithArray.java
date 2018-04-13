package net.check321.algorithms.sorting.advanced;

import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 堆排序
 * @description 将数组用Heapify完成排序
 * @date 2018/4/13 18:22
 */
@Component
public class HeapSortWithArray extends BaseSortable implements Sortable {
    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        int n = arrs.length;
        // 通过heapify将数组构成一个完全二叉树
        // arrs[index]从0开始，二叉树最后一个叶子节点的父节点Index为(count - 1)/2
        for (int i = (n - 1 - 1) / 2; i >= 0; i--) {
            shiftDown(arrs, n, i);
        }

        // MaxHeap的头节点元素是数组最大值，遍历取出头节点放到尾部，再做Heapify重复该动作，
        for (int i = n - 1; i >= 0; i--) {
            // 将头节点（最大值）放到数组尾部
            commonUtils.swap(arrs, 0, i);
            // 剩余部分做heapify
            shiftDown(arrs,i,0);
        }

    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {

    }


    /**
     * shiftDown
     *
     * @param arrs
     * @param n
     * @param i
     */
    private void shiftDown(Comparable[] arrs, int n, int i) {
        // 待shiftDown元素
        Comparable e = arrs[i];

        // 存在子节点
        while (2 * i + 1 < n) {
            // 左子节点
            int j = 2 * i + 1;
            // 存在子右节点 且 右节点 > 左节点 取右节点
            if (j + 1 < n && arrs[j + 1].compareTo(arrs[j]) > 0) {
                j += 1;
            }

            // 待shiftDown元素 > 子节点 => 不需要shiftDown
            if (e.compareTo(arrs[j]) >= 0) {
                break;
            }

            arrs[i] = arrs[j];
            i = j;
        }
        // 只做一次交换
        arrs[i] = e;
    }
}
