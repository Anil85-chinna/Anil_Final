package com.practice;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Practice {
	public void usingSlidingWindow(String str) {
		Set<Character> storeSet = new HashSet<>();
		int left = 0;
		int right = 0;
		int count = 0;
		int strLength = Integer.MIN_VALUE;
		char[] chAr = str.toCharArray();
		for (int i = 0; i < str.length(); i++) {
			while (storeSet.contains(chAr[i])) {
				storeSet.remove(chAr[left]);
				left++;
			}
			storeSet.add(chAr[i]);
			count = i - left + 1;

			strLength = Math.max(strLength, count);
		}
		System.out.println("the max length is = " + strLength);

	}

	public void usingStreams() {
		String str = "$123,840/y";
		String result = str.chars().mapToObj(c -> (char) c).filter(ch -> Character.isDigit(ch))
				.map(c -> String.valueOf(c)).collect(Collectors.joining());
		System.out.println("the output is = " + Integer.parseInt(result));

		StringBuilder sb = new StringBuilder();
		for (char c : str.toCharArray()) {
			if (Character.isDigit(c)) {
				sb.append(c);
			}
		}
		System.out.println("using stringbuilder  = " + Integer.parseInt(sb.toString()));
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String st = "abcd";
		Practice p = new Practice();
		p.usingSlidingWindow(st);
		p.usingStreams();

	}

}
