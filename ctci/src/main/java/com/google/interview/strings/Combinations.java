package com.google.interview.strings;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
	private StringBuilder out = new StringBuilder();
	private final String in;
	
	public Combinations( final String str ){ in = str; }
	public void combine() { combine( 0 ); }
	
	private void combine(int start ) {
		for( int i = start; i < in.length(); ++i ){
			out.append( in.charAt(i) );
			System.out.println( out );
			if ( i < in.length() )
				combine( i + 1);
			out.setLength( out.length() - 1 );
		}
	}
	
	public static void main(String args[]) {
		System.out.println((new Combinations("hat").getCombinations("cat", new StringBuffer(""), 0)));
	}
	
	List getCombinations(String instr, StringBuffer outstr, int index) {
		List combinations = new ArrayList();
		for (int i = index; i < instr.length(); i++) {
			outstr.append(instr.charAt(i));
			combinations.add(outstr.toString());
			
			
			combinations.addAll(getCombinations(instr, outstr, i + 1));
			
			System.out.println(outstr);
			outstr.deleteCharAt(outstr.length() - 1);
			System.out.println(outstr);
		}
		
		System.out.println(combinations);
		return combinations;
	}
} 
