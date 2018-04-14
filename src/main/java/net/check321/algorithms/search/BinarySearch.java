package net.check321.algorithms.search;

import org.springframework.stereotype.Component;

/**
 * @author check321
 * @title 二分查找
 * @description
 * @date 2018/4/14 12:14
 */
@Component
public class BinarySearch implements Searchable {
    @Override
    public <T extends Comparable> int search(T[] arrs, T target) {

        // 查找[l .... r]范围
        int l = 0, r = arrs.length - 1;

        // 遍历查找
        while (l <= r) {
            // 二分点
            int mid = l + (r - l) / 2;

            // 命中目标
            if (target.compareTo(arrs[mid]) == 0) {
                return mid;
            }

            // 缩小范围[l ... mid - 1]
            if (target.compareTo(arrs[mid]) < 0) {
                r = mid - 1;
            } else {
                // 缩小范围[mid + 1...r]
                l = mid + 1;
            }

        }

        // 未查找到目标 返回-1
        return -1;
    }

    public static void main(String[] args) {
        Integer[] arrs = {3,5,7,8,9};

        Searchable binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arrs,9));
    }
}
