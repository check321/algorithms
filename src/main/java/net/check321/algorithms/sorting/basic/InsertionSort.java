package net.check321.algorithms.sorting.basic;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 插入排序
 * @description
 * @date 2018/4/5 11:14
 */
@Component
@Slf4j
public class InsertionSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {

        // 插入排序向前比较，故从第二元素开始
        for (int i = 1; i < arrs.length; i++) {

       /*     for (int j = i; j > 0 && arrs[j].compareTo(arrs[j -1]) < 0; j--) {
             *//* ver 1.0
                if(arrs[j].compareTo(arrs[i]) < 0){
                    commonUtils.swap(arrs,i,j);
                }else{
                    break;
                }*//*
                commonUtils.swap(arrs, j, j-1);
            }*/

            // ver 3.0 sorted element
            Comparable e = arrs[i];

            // ver 3.0 correct index
            int j = i;
            for (; j > 0 && e.compareTo(arrs[j - 1]) < 0; j--) {
                arrs[j] = arrs[j - 1];
            }
            arrs[j] = e;
        }
    }


    /**
     * 对数组[l...r]区间进行排序
     *
     * @param arrs
     * @param l
     * @param r
     */
    public void sort(Comparable[] arrs, int l, int r) {
        for (int i = l + 1; i <= r; i++) {
            Comparable e = arrs[i];

            int j = i;
            for (; j > l && e.compareTo(arrs[j - 1]) < 0; j--) {
                    arrs[j] = arrs[j - 1];
            }
            arrs[j] = e;
        }
    }

    public static void main(String[] args) {
        Sortable sorter = new InsertionSort();
        Integer[] arrs = {8, 7, 6, 5, 4, 3, 2, 1};
        sorter.sort(arrs, 6, 7);
        log.info("sorted arrs: {}", (Object) arrs);
    }
}
