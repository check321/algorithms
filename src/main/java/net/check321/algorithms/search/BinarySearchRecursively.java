package net.check321.algorithms.search;

/**
 * @author check321
 * @title 二分查找
 * @description 递归实现
 * @date 2018/4/14 12:50
 */
public class BinarySearchRecursively implements Searchable {
    @Override
    public <T extends Comparable> int search(T[] arrs, T target) {
        return search(arrs, 0, arrs.length, target);
    }


    /**
     * 递归范围查找
     *
     * @param arrs
     * @param l      [l ...
     * @param r      ...r]
     * @param target
     * @param <T>
     * @return
     */
    private <T extends Comparable> int search(T[] arrs, int l, int r, T target) {

        // 递归跳出点
        while (l > r) {
            return -1;
        }

        // 二分点
        int mid = l + (r - l) / 2;

        if (target.compareTo(arrs[mid]) == 0) {
            return mid;
        } else if (target.compareTo(arrs[mid]) < 0) {
            return search(arrs, l, mid - 1, target);
        } else {
            return search(arrs, mid + 1, r, target);
        }
    }

    public static void main(String[] args) {
        Integer[] arrs = {3,5,7,8,9};

        Searchable binarySearch = new BinarySearch();
        System.out.println(binarySearch.search(arrs,9));
    }
}
