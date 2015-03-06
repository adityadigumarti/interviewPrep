package com.google.interview.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class Graph<T> {

    List<Node<T>> vertices;

    public void add(Node<T> vertex) {
        if (vertices == null) {
            vertices = new ArrayList<Node<T>>();
        }

        vertices.add(vertex);
    }

    public void add(Node<T>... nodes) {
        for (Node<T> node : nodes) {
            add(node);
        }
    }

    public void dfs() {
        Stack<Node<T>> stack = new Stack<Node<T>>();
        Node<T> current = null;
        Node<T> next = null;

        for (Node<T> node : vertices) {

            if (!node.isVisited()) {
                node.print();
                node.setVisited();

                stack.push(node);

                while (!stack.isEmpty()) {
                    current = stack.peek();
                    next = current.getNextUnVisited();
                    if (next != null) {
                        next.print();
                        next.setVisited();
                        stack.push(next);
                    } else {
                        stack.pop();
                    }
                }
            }
        }

        reset();

    }

    private void reset() {
        for (Node<T> node : vertices) {
            node.reset();
        }

    }

    public void bfs() {
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        Node<T> current = null;
        Node<T> next = null;

        for (Node<T> node : vertices) {
            if (!node.isVisited()) {
                node.print();
                node.setVisited();
                q.add(node);

                while (!q.isEmpty()) {
                    current = q.remove();

                    while ((next = current.getNextUnVisited()) != null) {
                        next.print();
                        next.setVisited();
                        q.add(next);
                    }
                }
            }
        }

        reset();
    }

    public List<List<T>> depthLinkedList() {
        List<List<T>> list = new ArrayList<List<T>>();
        Queue<Node<T>> q = new LinkedList<Node<T>>();
        Queue<Node<T>> depth = new LinkedList<Node<T>>();
        Node<T> current = null;
        int height = 0;

        for (Node<T> node : vertices) {
            height = 0;

            if (!node.isVisited()) {
                q.add(node);
                if (list.size() == height) {
                    list.add(new ArrayList<T>());
                }
                list.get(height).add(node.getData());
                node.print();

                while (!q.isEmpty()) {
                    height++;
                    if (list.size() == height) {
                        list.add(new ArrayList<T>());
                    }
                    while (!q.isEmpty()) {
                        current = q.remove();
                        if (current.getChildren() != null)
                            depth.addAll(current.getChildren());
                    }

                    while (!depth.isEmpty()) {
                        current = depth.remove();
                        if (!current.isVisited()) {
                            current.print();
                            list.get(height).add(current.getData());
                            current.setVisited();
                            q.add(current);
                        }
                    }
                }

            }
        }

        reset();
        return list;
    }
}
