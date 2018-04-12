package net.check321.algorithms.structures;

import lombok.extern.slf4j.Slf4j;
import net.check321.algorithms.sorting.common.CommonUtils;

import javax.validation.constraints.Max;

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

    /**
     * Heap-Sort
     * @param arrs
     */
    public MaxHeap(T[] arrs){
        commonUtils = new CommonUtils();

        int n = arrs.length;
        data = (T[])new Comparable[n + 1];
        capacity = n;

        for (int i = 0; i < n; i++) {
            // Max-Heap从1开始
            data[i + 1] = arrs[i];
        }
        count = n;

        // Heapify
        // 最后一个非叶子节点: n/2
        for (int i = n/2; i >= 1 ; i--) {
            shiftDown(i);
        }

    }

    // 返回容器大小
    public int size() {
        return this.count;
    }

    // 是否为空
    public boolean isEmpty() {
        return this.count == 0;
    }

    // 插入元素
    public void insert(T item) {
        count += 1;
        data[count] = item;
        shiftUp(count);
    }

    // 抽取最大元素
    public T extractMax(){
        T item = data[1];
        commonUtils.swap(data,1,count);
        count --;
        shiftDown(1);
        return item;
    }

    // shiftDown操作，将头结点移动至树合适的位置
    private void shiftDown(int i){
        // 还有子节点的情况：MaxHeap还存在左子节点
        while (2 * i <= count){
            // 待交换节点：初始化为左节点
            int j = 2 * i;
            // 存在右节点 && 右节点 > 左节点
            if(j + 1 <= count && data[j+1].compareTo(data[j]) > 0){
                // 取右节点
                j += 1;
            }

            // 子节点小于等于父节点 符合最大堆特性
            if(data[j].compareTo(data[i]) <= 0){
                break;
            }
            commonUtils.swap(data,i,j);
            i = j;
        }
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
            log.info("index:{} item: {}", i, data[i]);
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
