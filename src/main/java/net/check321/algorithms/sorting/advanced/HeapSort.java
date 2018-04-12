package net.check321.algorithms.sorting.advanced;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import net.check321.algorithms.structures.MaxHeap;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title MaxHeapSort
 * @description 利用对数组Heapify的过程完成HeapSort
 * @date 2018/4/12 21:38
 */
@Component
@Slf4j
public class HeapSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        int n = arrs.length;
        MaxHeap<Comparable> heap = new MaxHeap<>(arrs);
        // 利用MaxHeap的extracMax()依次获取最大值，倒置进数组
        for (int i = n - 1; i >= 0; i--) {
            arrs[i] = heap.extractMax();
        }
    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {

    }
}
