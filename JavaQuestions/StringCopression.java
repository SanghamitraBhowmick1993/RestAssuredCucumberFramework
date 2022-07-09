package com.backend.actions;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class CountOccurance {

	public static void main(String[] args) {
		String str = "aaabbcccccddd";
		char[] words =str.toCharArray();
		HashMap<Character, Integer> map = new HashMap<>();
		for(Character word : words) {
			if(map.containsKey(word)) {
				map.put(word, map.get(word)+1);
			}
			else {
				map.put(word, 1);
			}
		}
		//Iterating
		StringBuilder sb = new StringBuilder();
		for(Character ch : map.keySet()) {
			sb.append(ch);
			sb.append(map.get(ch));
		}
		System.out.println(sb.toString());

	}

}
