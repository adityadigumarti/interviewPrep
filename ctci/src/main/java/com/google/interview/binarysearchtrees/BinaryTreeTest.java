package com.google.interview.binarysearchtrees;

public class BinaryTreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree<Integer> bTree = new BinaryTree<Integer>();
		
		bTree.insert(10);
		bTree.insert(23);
		bTree.insert(2);
		bTree.insert(29);
		bTree.insert(1);
		bTree.insert(8);
		bTree.insert(11);
		bTree.insert(0);
		bTree.insert(15);
		bTree.insert(27);
		bTree.insert(77);
		bTree.insert(79);
		
		System.out.println(bTree.isBalanced());
		
		System.out.println(bTree.getSuccessor(8));
		System.out.println(bTree.getSuccessor(10));
		System.out.println(bTree.getSuccessor(23));
		System.out.println(bTree.getSuccessor(77));
		System.out.println(bTree.getSuccessor(79));
		
//		bTree.preorder();
//		
//		System.out.println(bTree.getMin());
//		System.out.println(bTree.getMax());
		
	}

}
