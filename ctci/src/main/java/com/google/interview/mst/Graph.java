package com.google.interview.mst;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

/**
 * Vertices are numbered 0...n-1
 * 
 * 
 * @author diguma01
 * 
 */
public class Graph {
    public int numOfVertices;
    Queue<Edge> edges;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        edges = new PriorityQueue<Edge>();
    }

    public void addEdge(Edge edge) {
        if (edge.getVertex1() >= numOfVertices || edge.getVertex2() >= numOfVertices) {
            throw new IllegalArgumentException();
        }

        edges.add(edge);
    }

    public int getNumOfVertices() {
        return numOfVertices;
    }

    public void setNumOfVertices(int numOfVertices) {
        this.numOfVertices = numOfVertices;
    }

    public Queue<Edge> getEdges() {
        return edges;
    }

    public void setEdges(Queue<Edge> edges) {
        this.edges = edges;
    }

}
