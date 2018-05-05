package net.check321.algorithms.union;


/**
 * @author check321
 * @title 并查集
 * @description 基于树形结构解决连接问题（Conectivity Problem）的数据结构
 * @date 2018/5/5 14:48
 */
public class UnionFind implements Unionable {

    // 本质上是一个数组 元素用于代表集合的分类
    private Integer[] index;

    private int count;

    public UnionFind(int count) {
        index = new Integer[count];
        for (int i = 0; i < count; i++) {
            index[i] = i;
        }
        this.count = count;
    }

    @Override
    public Integer find(int idx) {
        assert idx >= 0 && idx < count;
        return index[idx];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return index[p].compareTo(index[q]) == 0;
    }

    @Override
    public void union(int p, int q) {
        Integer pIdx = find(p);
        Integer qIdx = find(q);

        // 属于同一并集
        if (pIdx.compareTo(qIdx) == 0) {
            return;
        }

        // index[p] = index[q]
        for (int i = 0; i < count; i++) {
            if (index[i].compareTo(pIdx) == 0) {
                index[i] = qIdx;
            }
        }

    }
}
