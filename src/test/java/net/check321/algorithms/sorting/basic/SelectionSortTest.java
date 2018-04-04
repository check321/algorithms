package net.check321.algorithms.sorting.basic;

import net.check321.algorithms.sorting.Sortable;
import net.check321.algorithms.sorting.common.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SelectionSortTest {

    @Autowired
    private Sortable selectionSorting;

    @Autowired
    private CommonUtils commonUtils;

    @Test
    public void sortingTest() {
        Integer[] randomArrs = commonUtils.generateRandomArrs(10000, 1, 100000);
        selectionSorting.sort(randomArrs);
    }

}
