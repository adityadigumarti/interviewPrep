package com.google.interview.datastructures;

public class UnionFind {

    int array[];

    public UnionFind(int numOfVertices) {
        array = new int[numOfVertices];
        for (int i = 0; i < numOfVertices; i++) {
            array[i] = i;
        }
    }

    public boolean find(int p, int q) {
        return root(p) == root(q);
    }

    public int root(int p) {
        while (array[p] != p) {
            p = array[p];
        }

        return p;
    }

    public void union(int p, int q) {
        int pid_p = root(p);
        int pid_q = root(q);

        array[pid_q] = pid_p;
    }

}
