package net.check321.algorithms.sorting.advanced;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author check321
 * @title Merge-Sort 归并排序
 * @description O(nlogn)
 * @date 2018/4/6 20:36
 */
@Component
@Slf4j
public class MergeSort extends BaseSortable implements Sortable {

    @Autowired
    @Qualifier("insertionSort")
    private Sortable insertionSort;

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {
        this.mergeSort(arrs, 0, arrs.length - 1);
    }

    @Override
    public void sort(Comparable[] arrs, int l, int r) {
    }


    /**
     * 递归分治数组至单个元素 [l...r]
     *
     * @param arrs 待归并数组
     * @param l    头元素角标
     * @param r    尾元素角标
     */
    private void mergeSort(Comparable[] arrs, int l, int r) {

        // 数组不大时可用Insertion-Sort提升性能
        if ((r - l) <= 15) {
            insertionSort.sort(arrs, l, r);
            return;
        }

        // 跳出递归条件
        if (l >= r) {
            return;
        }

        // 中间点
        int mid = (l + r) / 2;
        // 分治左侧
        this.mergeSort(arrs, l, mid);
        // 分治右侧
        this.mergeSort(arrs, mid + 1, r);
        // 归并
        if (arrs[mid].compareTo(arrs[mid + 1]) > 0) {
            this.merge(arrs, l, mid, r);
        }
    }


    /**
     * 归并操作
     *
     * @param arrs 待归并数组
     * @param l    起始角标
     * @param mid  中点角标
     * @param r    右边角标
     */
    private void merge(Comparable[] arrs, int l, int mid, int r) {

        // 拷贝临时数组方便归并比较操作
        Comparable[] temp = Arrays.copyOfRange(arrs, l, r + 1);

        // 分治左侧角标，从l开始
        int i = l;
        // 分治右侧角标，从mid + 1开始
        int j = mid + 1;

        // 循环归并
        for (int k = l; k <= r; k++) {
            // 分治左侧没有元素，取分治右侧元素
            if (i > mid) {
                arrs[k] = temp[j - l];
                j++;
            } else if (j > r) {
                // 分治右侧没有元素，取分治左侧元素
                arrs[k] = temp[i - l];
                i++;
            } else if (temp[i - l].compareTo(temp[j - l]) < 0) {
                // 分治左侧 < 分治右侧, 取左侧
                arrs[k] = temp[i - l];
                i++;
            } else {
                // 分治右侧 < 分治左侧, 取右侧
                arrs[k] = temp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        MergeSort sorter = new MergeSort();
        Integer[] arrs = {8, 7, 6, 5, 4, 3, 2, 1};
        sorter.sort(arrs);
        log.info("sorted arrs: {}", (Object) arrs);
    }

}
