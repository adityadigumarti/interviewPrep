package com.google.interview.binarysearchtrees;

import com.google.interview.linkedlist.LinkedList;

public class LinkedListToBt {
	
	public static void main(String args[]) {
		LinkedList<Integer> sortedList = createSortedLinkedList();
		
		Node<Integer> root = convertToBinaryTree(sortedList);
		
		System.out.println(root);
		
		
		
	}

	private static LinkedList<Integer> createSortedLinkedList() {
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		for(int i = 0; i < 11; i++)
			list.insert(i);
		
		return list;
	}
	
	public static Node<Integer> convertToBinaryTree(LinkedList<Integer> sortedList) {
		int length = sortedList.getSize();
		
		return convertToBinaryTree(0, length - 1, sortedList);
		
	}

	private static Node<Integer> convertToBinaryTree(int start, int end, LinkedList<Integer> sortedList) {
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		
		com.google.interview.stack.Node<Integer> middle = getNode(mid, sortedList);
		
		Node root = new Node(middle.getData(), null);
		
		
		
		root.setLeft(convertToBinaryTree(start, mid - 1, sortedList));
		root.setRight(convertToBinaryTree(mid + 1, end, sortedList));
		
		return root;
	}

	private static com.google.interview.stack.Node<Integer> getNode(int mid, LinkedList<Integer> sortedList) {
		com.google.interview.stack.Node<Integer> node = sortedList.getHead();
		for(int i = 0; i < mid; i++)
			node = node.getNext();
		
		return node;
	}

}
