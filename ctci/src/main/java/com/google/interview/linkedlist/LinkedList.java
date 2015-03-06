package com.google.interview.linkedlist;

import java.security.InvalidParameterException;

import com.google.interview.stack.Node;

public class LinkedList<T extends Comparable<T>> {

    private Node<T> head;
    private Node<T> tail;
    int size = 0;

    /**
     * Inserts at the end.
     * 
     * @param data
     */
    public void insert(T data) {
        if (head == null) {
            head = new Node(data);
            tail = head;
        } else {
            Node<T> node = new Node(data);
            tail.setNext(node);
            tail = node;
        }

        size++;
    }

    /**
     * Deletes all occurrences of data.
     * 
     * @param data
     */
    public void delete(T data) {
        if (head == null) {
            throw new IllegalStateException("Empty Linked List.");
        }

        while (head != null && head.getData() == data) {
            head = head.getNext();
        }

        Node<T> node = head;
        while (node != null && node.getNext() != null) {
            if (node.getNext().getData() == data) {
                node.setNext(node.getNext().getNext());
                size--;
            }

            node = node.getNext();
        }
    }

    public void delete(Node<T> node) {
        if (node == tail) {
            Node<T> prev = findPrevious(node);
            prev.setNext(null);
            tail = prev;
        } else {
            if (node == head) {
                head = node.getNext();
            }

            node.setData(node.getNext().getData());
            node.setNext(node.getNext().getNext());
        }
        size--;
    }

    public Node<T> getNode(T data) {
        Node<T> node = head;

        while (node != null && node.getData() != data) {
            node = node.getNext();
        }

        return node;
    }

    public void quickSort(T data) {
        Node<T> mid = getNode(data);

        Node<T> first = head;
        Node<T> second = mid.getNext();
        Node<T> temp = null;

        while (first != mid) {
            temp = first.getNext();
            if (first.getData().compareTo(data) > 0) {
                move(first, mid);
            }

            first = temp;
            System.out.println(toString());
        }

        System.out.println(toString());
        while (second != null) {
            temp = second.getNext();

            if (second.getData().compareTo(data) < 0) {
                move(second, head);
            }

            second = temp;
            System.out.println(toString());
        }
    }

    public void move(Node<T> first, Node<T> mid) {
        T data = first.getData();

        System.out.println(toString());
        delete(first);
        System.out.println(toString());

        Node node = new Node(data);

        Node temp = mid.getNext();
        mid.setNext(node);
        node.setNext(temp);

    }

    private Node<T> findPrevious(Node<T> first) {
        Node<T> previous = head;

        while (previous.getNext() != first) {
            previous = previous.getNext();
        }

        return previous;
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        Node<T> node = head;

        while (node != null) {
            s.append(node.toString() + ",");
            node = node.getNext();
        }

        return s.toString();
    }

    public int getSize() {
        return size;
    }

    public void foldLinkedList() {
        Node x = head;
        Node y = head.getNext().getNext();

        while (y.getNext() != null && y.getNext().getNext() != null) {
            x = x.getNext();
            y = y.getNext().getNext();
        }

        x = x.getNext();
        y = y.getNext();

        // Reset
        y = x.getNext();
        x = head;

        Node nextX = null;
        Node nextY = null;

        while (y.getNext() != null) {
            nextX = x.getNext();
            nextY = y.getNext();

            x.setNext(y);
            y.setNext(nextX);

            x = nextX;
            y = nextY;

            System.out.println(x);
            System.out.println(y);
        }

        x.setNext(y);
        tail = y;

    }

    public boolean isPalindrome() {
        return isPalindrome(head, head) != null ? true : false;
    }

    private Node<T> isPalindrome(Node<T> left, Node<T> right) {
        if (right == null) {
            return left;
        }

        left = isPalindrome(left, right.getNext());

        if (left != null) {
            boolean palindrome = (left.getData().compareTo(right.getData()) == 0);

            if (palindrome) {
                return left.getNext() != null ? left.getNext() : left;
            }
        }

        return null;

    }

    public void deleteKthFromLast(int k) {
        int i = k;
        Node<T> pointerOne = head;
        Node<T> pointerTwo = head;

        while (i != 0) {
            pointerOne = pointerOne.getNext();

            if (pointerOne == null) {
                throw new InvalidParameterException();
            }
        }

        while (pointerOne != null) {
            pointerOne = pointerOne.getNext();
            pointerTwo = pointerTwo.getNext();
        }

        delete(pointerTwo);
    }

    public void reverse() {
        head = recursiveReverse(head, null);
    }

    private Node recursiveReverse(Node<T> current, Node<T> previous) {
        Node<T> temp = null;
        if (current.getNext() == null) {
            current.setNext(previous);
            return current;
        } else {
            temp = recursiveReverse(current.getNext(), current);
            current.setNext(previous);
            return temp;
        }

    }

    private void nonRecursiveReverse() {
        Node<T> current = head;
        Node<T> previous = null;
        Node<T> temp = null;

        while (current.getNext() != null) {
            temp = current.getNext();
            current.setNext(previous);
            previous = current;
            current = temp;
        }

    }

	public Node<T> getHead() {
		return head;
	}
    
    
    

}
