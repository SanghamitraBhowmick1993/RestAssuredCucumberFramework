package com.backend.actions;

import java.util.Stack;

public class RevOnlyCharacter {

	public static void main(String[] args) {
		String str = "test123pop3456pyt11";
		Stack<Character> stack = new Stack<Character>();
		for(char c : str.toCharArray()) {
			if(Character.isLetter(c)) {
				stack.push(c);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(char c : str.toCharArray()) {
			if(Character.isLetter(c)) {
				sb.append(stack.pop());
			}
			else {
				sb.append(c);
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	
}
