package net.check321.algorithms.search;

/**
* @title 查找接口
* @description
* @author check321
* @date 2018/4/14 12:10
*/
public interface Searchable {

    /**
     * 查找目标
     * @param arrs 目标容器
     * @param target 目标元素
     * @param <T>
     * @return
     */
    <T extends Comparable> int search(T[] arrs,T target);
}
