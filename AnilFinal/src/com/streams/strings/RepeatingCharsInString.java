package com.streams.strings;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class RepeatingCharsInString {
	// find the firstNonReapeatingCharacter
	public void usingBruthForce(String s1) {
		if (s1 == null || s1.isEmpty()) {
			return;
		}

		Map<Character, Integer> newMap = new LinkedHashMap<>();
		for (Character ch : s1.toCharArray()) {
			newMap.put(ch, newMap.getOrDefault(ch, 0) + 1);
		}
		System.out.println(newMap);
		for (Map.Entry<Character, Integer> entry : newMap.entrySet()) {
			if (entry.getValue() == 1) {
				System.out.println("The first non repeating char in string is = " + entry.getKey());
				break;
			}
		}

	}

	/*
	 * 🔑 Key rule to remember (interview-friendly) groupingBy(classifier,
	 * mapFactory, downstream)
	 * 
	 * 
	 * So:
	 * 
	 * Function.identity() → key
	 * 
	 * LinkedHashMap::new → preserves order
	 * 
	 * Collectors.counting() → frequency
	 */
	public void usingStreams(String s1) {
		if (s1 == null || s1.isEmpty()) {
			System.out.println("empty string");
			return;
		}
		Character ch = s1.chars().mapToObj(e -> (char) e)
				.collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting())).entrySet().stream()
				.filter(ele -> ele.getValue() == 1).findFirst().map(ele -> ele.getKey()).get();
		System.out.println("The first non repeating char using streams = " + ch);

	}

	// last non repeating char in given string
	public void usingBruteForceLastNonRepeatingCharInString(String s1) {
		if (s1 == null || s1.isEmpty()) {
			System.out.println("empty string");
			return;
		}
		Map<Character, Integer> frequencyOfEachChar = new LinkedHashMap<>();
		for (Character cc : s1.toCharArray()) {
			frequencyOfEachChar.put(cc, frequencyOfEachChar.getOrDefault(cc, 0) + 1);
		}
		List<Character> nonRepeatingChars = new LinkedList<>();
		for (Map.Entry<Character, Integer> uniqueChar : frequencyOfEachChar.entrySet()) {
			if (uniqueChar.getValue() == 1) {
				nonRepeatingChars.add(uniqueChar.getKey());
			}
		}
		System.out.println("this is list of unique chars in given string = " + nonRepeatingChars);
		System.out.println("The last non repeating char is = " + nonRepeatingChars.getLast());
		System.out.println("The last non repeating char is = " + nonRepeatingChars.get(nonRepeatingChars.size() - 1));
	}

	public void usingStreamLastNonRepeatingCharInString(String s1) {
		if (s1 == null || s1.isEmpty()) {
			System.out.println("empty");
			return;
		}
		List<Character> listOfNonRepeatingChars = s1.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(chr -> chr, LinkedHashMap::new, Collectors.counting())).entrySet()
				.stream().filter(enty -> enty.getValue() == 1).map(ele -> ele.getKey()).toList();
		System.out.println(listOfNonRepeatingChars);
		System.out.println(
				"printing the last char using streams with GETLAST METHOD = " + listOfNonRepeatingChars.getLast());
		System.out.println("the last char is " + listOfNonRepeatingChars.get(listOfNonRepeatingChars.size() - 1));
	}

	// now printing the only non repeating chars
	public void usingStreamsNonRepeatingChars(String s1) {
		if (s1 == null || s1.isEmpty()) {
			System.out.println("empty");
			return;
		}
		List<Character> nonRepeatingChars = s1.chars().mapToObj(ch -> (char) ch)
				.collect(Collectors.groupingBy(ele -> ele, Collectors.counting())).entrySet().stream()
				.filter(m -> m.getValue() == 1).map(ma -> ma.getKey()).toList();
		System.out.println(nonRepeatingChars);
	}

	// occurence of each char in string using sets
	public void eachCharCountUsingSets(String s1) {
		Set<Character> charSet = new HashSet<>();
		char[] charArray = s1.toCharArray();
		for (char ch : charArray) {
			charSet.add(ch);
		}
		for (char c1 : charSet) {
			int count = 0;
			for (char c2 : charArray) {
				if (c2 == c1) {
					count++;
				}
			}
			System.out.println("each char print using set = " + c1 + " - is the char - " + count);
		}
	}

	public void firstRepeatingCharUsingStreams(String str) {
		Character firstRepeatingChar = str.chars().mapToObj(ele -> (char) ele)
				.collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
				.entrySet().stream().filter(ele -> ele.getValue() == 2).findFirst().get().getKey();
		System.out.println("the first repeating cha "+firstRepeatingChar);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "iterviewer";
		RepeatingCharsInString rcs = new RepeatingCharsInString();
		rcs.usingBruthForce(s);
		rcs.usingStreams(s);
		rcs.usingBruteForceLastNonRepeatingCharInString(s);
		rcs.usingStreamLastNonRepeatingCharInString(s);
		rcs.usingStreamsNonRepeatingChars(s);
		rcs.eachCharCountUsingSets(s);
		rcs.firstRepeatingCharUsingStreams(s);

	}

}
