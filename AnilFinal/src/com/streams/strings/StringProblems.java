package com.streams.strings;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringProblems {

	// we need group by length of string
	public void usingStreams(List<String> ls) {
		Map<Integer, List<String>> lengthOfStrings = ls.stream().collect(Collectors.groupingBy(String::length));
		System.out.println(lengthOfStrings);
	}

	public void findLongestWordInString(String s1) {
		// we are making split twice so we can make it once as below
		String[] words = s1.split("\\s+");
		int maxLength = Arrays.stream(words).mapToInt(str -> str.length()).max().getAsInt();
		List<String> maxLengthStrings = Arrays.stream(words).filter(str -> str.length() == maxLength)
				.collect(Collectors.toList());
		System.out.println("anil = " + maxLengthStrings);
	}
	/*
	 * String longestWord = Arrays.stream(str.split("\\s+"))
	 * .max(Comparator.comparingInt(String::length)) .orElse("");
	 * 
	 * System.out.println(longestWord);
	 */
	/*
	 * 7. Remove Duplicate Characters: Given a string, remove duplicate characters
	 * while preserving the original order.
	 * 
	 * input: "programming" output: "progamin"
	 */

	public void usingStreamsForRemoveDuplicates(String s1) {
		String result = s1.chars().distinct().mapToObj(ele -> (char) ele).map(el -> String.valueOf(el))
				.collect(Collectors.joining());
		System.out.println(result);
	}
	/*
	 * public static String findLongestWordOptimized(String str) { String longest =
	 * ""; String current = "";
	 * 
	 * for (int i = 0; i < str.length(); i++) { char ch = str.charAt(i);
	 * 
	 * if (ch != ' ') { current += ch; } else { if (current.length() >
	 * longest.length()) { longest = current; } current = ""; } }
	 * 
	 * // Check last word if (current.length() > longest.length()) { longest =
	 * current; }
	 * 
	 * return longest; }
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> list = Arrays.asList("apple", "grape", "mango", "peach", "berry");
		String s1 = "anil chinna vemua";
		StringProblems sp = new StringProblems();
		sp.usingStreams(list);
		sp.findLongestWordInString(s1);
		sp.usingStreamsForRemoveDuplicates(s1);

	}

}
