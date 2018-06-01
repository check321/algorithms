package net.check321.algorithms.structures.graph.basic;

/**
 * @author check321
 * @title DenseGraph By Adjacency Matrix
 * @description
 * @date 2018/6/1 14:26
 */
public class DenseGraph {

    private Integer v; // vertex

    private Integer e; // edge

    private Boolean directed; // is directed

    private Boolean[][] g; // graph (matirx container)

    public DenseGraph(Integer v, Boolean directed) {
        assert v >= 0;
        this.v = v;
        this.e = 0;
        this.directed = directed;
        this.g = new Boolean[v][v];
    }

    // getter
    public Integer V() {
        return this.v;
    }

    public Integer E() {
        return this.e;
    }

    // add a path from x to y
    public void addEdge(Integer x,Integer y){
        assert x >= 0 && x< v;
        assert y >= 0 && y< v;

        if(hasEdge(x,y)){
            return;
        }

        g[x][y] = true;
        if(!directed){
            // undirected graph
            g[y][x] = true;
        }

        e++;
    }

    // does it exisit a way from x to y
    public Boolean hasEdge(Integer x,Integer y){
        assert x >= 0 && x< v;
        assert y >= 0 && y< v;

        return g[x][y];
    }

}
