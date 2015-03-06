package com.google.interview.binarysearchtrees;

public class Node<T extends Comparable> implements Cloneable {
	
	private T data;
	private Node<T> left;
	private Node<T> right;
	private Node<T> parent;
	
	
	public Node(T data, Node<T> parent) {
		this.data = data;
		this.parent = parent;
	}
	
	public void setLeft(Node<T> left) {
		this.left = left;
	}
	
	public void setRight(Node<T> right) {
		this.right = right;
	}
	
	public Node<T> getRight() {
		return right;
	}
	
	public Node<T> getLeft() {
		return left;
	}
	
	public T getData() {
		return data;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}
	
	
	//public Node<T> clone() {
		//return super.clone();
	//}
	
}
