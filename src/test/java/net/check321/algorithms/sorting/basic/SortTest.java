package net.check321.algorithms.sorting.basic;

import net.check321.algorithms.sorting.Sortable;
import net.check321.algorithms.sorting.common.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SortTest {

    @Autowired
    @Qualifier("selectionSort")
    private Sortable selectionSort;

    @Autowired
    @Qualifier("insertionSort")
    private Sortable insertionSort;

    @Autowired
    private CommonUtils commonUtils;

    @Test
    public void sortingTest() {
        Integer[] randomArrs = commonUtils.generateRandomArrs(10000, 1, 10000);
        Integer[] randomArrs1 = Arrays.copyOf(randomArrs,randomArrs.length);

        selectionSort.sort(randomArrs);
        insertionSort.sort(randomArrs1);
    }

}
