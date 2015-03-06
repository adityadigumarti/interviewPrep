package com.google.phone.practice;

public class LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    private Node<T> getHead(Node<T> node) {
        return node;
    }

    private void setHead(Node<T> head) {
        this.head = head;
    }

    private int getSize() {
        return this.size;
    }

    private void insert(T data) {
        Node<T> node = new Node(data);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    private void delete(int index) {
        if (size == 0) {
            throw new IllegalStateException("Cannot delete from an Empty List");
        }

        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException(String.format("Index has to be in the Range %d and %d", 0, size - 1));
        }

        if (index == 0) {
            head = head.getNext();

            if (size == 1) {
                tail = null;
            }

            size--;
            return;
        }

        Node<T> previous = head;

        for (int i = 0; i < index - 1; i++) {
            previous = head.getNext();
        }

        previous.setNext(previous.getNext().getNext());

        if (index == size - 1) {
            tail = previous.getNext();
        }

        size--;

    }
}
