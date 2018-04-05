package net.check321.algorithms.sorting.basic;

import net.check321.algorithms.annotations.Profiler;
import net.check321.algorithms.sorting.BaseSortable;
import net.check321.algorithms.sorting.Sortable;
import org.springframework.stereotype.Component;

@Component
public class SelectionSort extends BaseSortable implements Sortable {

    @Override
    @Profiler
    public void sort(Comparable[] arrs) {

        for (int i = 0; i < arrs.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arrs.length; j++) {
                if (arrs[j].compareTo(arrs[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            commonUtils.swap(arrs,i,minIndex);
        }

    }
}
