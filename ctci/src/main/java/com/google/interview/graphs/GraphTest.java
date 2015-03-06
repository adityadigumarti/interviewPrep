package com.google.interview.graphs;

public class GraphTest {
	
	public static void main(String args[]) {
		Node<String> a = new Node("A");
		Node<String> b = new Node("B");
		Node<String> c = new Node("C");
		Node<String> d = new Node("D");
		Node<String> e = new Node("E");
		Node<String> f = new Node("F");
		Node<String> g = new Node("G");
		Node<String> h = new Node("H");
		Node<String> i = new Node("I");
		Node<String> j = new Node("J");
		Node<String> k = new Node("K");
		Node<String> l = new Node("L");
		
		
		a.addChildren(b,c,d);
		b.addChildren(e,f);
		c.addChildren(g);
		d.addChildren(h);
		h.addChildren(i,j);
		k.addChild(l);
		
		Graph<String> graph = new Graph<String>();
		
		graph.add(a,b,c,d,e,f,g,h, i, j, k, l);
		
		graph.bfs();
		
		System.out.printf("%n%n%n%n");
		
		System.out.println(graph.depthLinkedList());
		
		
	}

}
