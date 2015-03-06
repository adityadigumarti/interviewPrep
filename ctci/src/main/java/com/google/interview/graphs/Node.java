package com.google.interview.graphs;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	
	private T data;
	private List<Node<T>> children;
	private boolean visited = false;
	int index = -1;
	
	public Node(T data) {
		this.data = data;
	}
	
	
	public T getData() {
		return data;
	}
	
	public void setData(T data) {
		this.data = data;
	}
	
	public List<Node<T>> getChildren() {
		return children;
	}
	
	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}
	
	public void addChild(Node<T> node) {
		if(children == null) {
			children = new ArrayList<Node<T>>();
		}
		
		children.add(node);
	}
	
	public void addChildren(Node<T>... nodes) {
		for(Node<T> node : nodes) {
			addChild(node);
		}
	}
	
	

	public boolean isVisited() {
		return visited;
	}
	
	public void setVisited() {
		visited = true;
	}

	public void reset() {
		this.visited = false;
		this.index = -1;
	}
	
	
	public Node<T> getNextUnVisited() {
		index++;
		Node<T> next = null;
		
		while(children != null && children.size() != index && children.get(index).isVisited()) {
			index++;
		}
		
		if(children != null && index != children.size()) {
			next = children.get(index);
		}
		
		return next;
	}
	
	
	public String toString() {
		return data.toString();
	}
	
	public void print() {
		System.out.println(toString());
	}
	
	
	

}
