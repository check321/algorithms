package net.check321.algorithms.structures;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class MaxHeapTest {

    @Test
    public void test() {
        int capacity = 7;
        MaxHeap<Integer> heap = new MaxHeap<>(capacity);
        for (int i = 0; i < capacity; i++) {
            heap.insert(i);
        }

        heap.printHeap();

        for(int i = 0; i < capacity; i++) {
            Integer max = heap.extractMax();
            log.info("max: {}",max);
        }

        log.info("heap size: {}",heap.size());

    }
}
