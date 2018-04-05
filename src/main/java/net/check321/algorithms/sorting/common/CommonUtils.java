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
    public void printArr(Object[] arrs,String title) {
        log.info("-----{}-----: {}", title,(Object) arrs);
    }


    /**
     * 范围内生成随机元素且固定大小的数组 [rangeL-rangeR]
     * @param size 数组大小
     * @param rangeL 元素左区间
     * @param rangeR 元素右区间
     * @return
     */
    public Integer[] generateRandomArrs(int size, int rangeL, int rangeR) {

        if (rangeR < rangeL) {
            rangeL = rangeL ^ rangeR;
            rangeR = rangeL ^ rangeR;
            rangeL = rangeL ^ rangeR;
        }

        Integer[] arrs = new Integer[size];
        for (int i = 0; i < size; i++) {
            // 生成区间随机数 [0.0-1.0] * ([rangeL-rangeR] + offset)
            arrs[i] = new Integer((int) (Math.random() * (rangeR - rangeL + 1) + rangeL));
        }
        return arrs;
    }

    /**
     * 生成近似有序的数组
     * @param size 数组大小
     * @param swapTimes 交换次数 该次数越大数组有序性越低
     * @return
     */
    public Integer[] generateNearlyOrderedArrs(int size,int swapTimes){

        // 完全有序数组
        Integer[] arrs = new Integer[size];
        for (int i = 0; i < size; i++) {
            arrs[i] = i;
        }

        // 随机交换swapTimes次元素
        for (int i = 0; i < swapTimes; i++) {
            int j = (int) (Math.random() * size);
            int k = (int) (Math.random() * size);

            this.swap(arrs,j,k);
        }

        return arrs;
    }

}
