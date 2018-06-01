package net.check321.algorithms.structures.graph.basic;

import java.util.Vector;

/**
 * @author check321
 * @title Sparse Graph By Adjacency Lists
 * @description
 * @date 2018/6/1 14:53
 */
public class SparseGraph {

    private Integer v; // vertex

    private Integer e; // edge

    private Boolean directed; // is drected graph

    private Vector<Integer>[] g; // graph

    // getter
    public Integer V() {
        return this.v;
    }

    public Integer E() {
        return this.e;
    }

    public SparseGraph(Integer v, Boolean directed) {
        assert v >= 0;

        this.v = v;
        this.e = 0;
        this.directed = directed;

        this.g = new Vector[v];
        for (int i = 0; i < v; i++) {
            g[i] = new Vector();
        }
    }

    // add a path from x to y
    public void addEdge(Integer x, Integer y) {

        assert x >= 0 && x < v;
        assert y >= 0 && y < v;

        g[x].add(y);
        if (x != y && !directed) {
            g[y].add(x);
        }

        e++;
    }
}
