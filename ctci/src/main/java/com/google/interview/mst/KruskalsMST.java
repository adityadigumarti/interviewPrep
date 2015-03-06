package com.google.interview.mst;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.google.interview.datastructures.UnionFind;

public class KruskalsMST {

    public static void main(String args[]) {
        PriorityQueue<Edge> pq = new PriorityQueue<Edge>();

        pq.add(new Edge(0, 1, 4));
        pq.add(new Edge(0, 7, 8));
        pq.add(new Edge(1, 7, 11));
        pq.add(new Edge(2, 3, 7));
        pq.add(new Edge(3, 4, 9));
        pq.add(new Edge(4, 5, 10));
        pq.add(new Edge(5, 6, 2));
        pq.add(new Edge(7, 6, 1));
        pq.add(new Edge(7, 8, 7));
        pq.add(new Edge(2, 8, 2));
        pq.add(new Edge(2, 5, 4));
        pq.add(new Edge(3, 5, 14));
        pq.add(new Edge(1, 2, 8));
        pq.add(new Edge(8, 6, 6));

        Graph graph = new Graph(9);
        graph.setEdges(pq);

        new KruskalsMST().findMST(graph);
    }

    public void findMST(Graph graph) {
        UnionFind unionFind = new UnionFind(graph.getNumOfVertices());
        List<Edge> mst = new ArrayList<Edge>();

        Queue<Edge> edges = graph.getEdges();
        Edge edge = null;
        while (!edges.isEmpty()) {
            edge = edges.remove();

            if (!unionFind.find(edge.getVertex1(), edge.getVertex2())) {
                unionFind.union(edge.getVertex1(), edge.getVertex2());
                mst.add(edge);
            }
        }

        System.out.println(mst);

    }

}
