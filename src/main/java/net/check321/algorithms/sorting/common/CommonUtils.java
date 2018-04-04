package net.check321.algorithms.sorting.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CommonUtils {

    /**
     * 数组两个元素交换
     *
     * @param arrs 待交换数组
     * @param i    元素1
     * @param j    元素2
     */
    public void swap(Object[] arrs, int i, int j) {
        Object temp = arrs[i];
        arrs[i] = arrs[j];
        arrs[j] = temp;
    }


    /**
     * 输出数组元素
     *
     * @param arrs
     */
    public void printArr(Object[] arrs) {
        log.info("Sorting Result: {}",(Object) arrs);
    }

}
