package net.check321.algorithms.structures;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.sorting.common.CommonUtils;

/**
 * @author check321
 * @title Max-Heap 最大堆实现
 * @description
 * @date 2018/4/12 15:08
 */
@Slf4j
public class MaxHeap<T extends Comparable> {

    // 元素集合
    private T[] data;

    // 容器元素个数
    private int count;

    // 容器大小
    private int capacity;

    CommonUtils commonUtils;

    // 根据元素数量构造容器
    public MaxHeap(int capacity) {
        this.data = (T[]) new Comparable[capacity + 1];
        this.count = 0;
        this.capacity = capacity;
        commonUtils = new CommonUtils();
    }

    // 返回容器大小
    public int size() {
        return this.count;
    }

    // 是否为空
    public boolean isEmpty() {
        return this.count == 0;
    }

    public void insert(T item) {
        count += 1;
        data[count] = item;
        shiftUp(count);
    }


    // 最大堆用shif-up方式排序
    private void shiftUp(int i) {
        while (i > 1 && data[i / 2].compareTo(data[i]) < 0) {
            // 父节点小于子节点
            commonUtils.swap(data, i / 2, i);
            // 下一个父节点
            i /= 2;
        }

    }

    public void printHeap() {
        for (int i = 1; i < data.length; i++) {
            log.info("index:{} item: {}",i, data[i]);
        }

    }

    public static void main(String[] args) {
        int capacity = 7;
        MaxHeap<Integer> heap = new MaxHeap<>(capacity);
        for (int i = 0; i < capacity; i++) {
            heap.insert(i);
        }

        heap.printHeap();
    }

}
