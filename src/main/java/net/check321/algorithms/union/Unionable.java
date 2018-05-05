package net.check321.algorithms.union;

/**
 * @author check321
 * @title 并集操作接口
 * @description
 * @date 2018/5/5 14:55
 */
public interface Unionable {


    /**
     * 返回元素所属集合
     * @param idx
     * @param <T>
     * @return
     */
    <T extends Comparable> T find(int idx);

    /**
     * 返回入参元素是否为并集
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p , int q);


    /**
     * 合并元素
     * @param p
     * @param q
     */
    void union(int p , int q);
}
