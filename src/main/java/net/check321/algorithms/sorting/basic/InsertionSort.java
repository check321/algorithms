package net.check321.algorithms.sorting.basic;

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
public class InsertionSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {

        // 插入排序向前比较，故从第二元素开始
        for (int i = 1; i < arrs.length; i++) {
            for (int j = i; j > 0 && arrs[j].compareTo(arrs[j -1]) < 0; j--) {
             /*   if(arrs[j].compareTo(arrs[i]) < 0){
                    commonUtils.swap(arrs,i,j);
                }else{
                    break;
                }*/
                commonUtils.swap(arrs, j, j-1);
            }
        }
    }
}
