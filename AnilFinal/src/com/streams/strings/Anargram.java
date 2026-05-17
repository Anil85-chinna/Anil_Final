package com.streams.strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Anargram {

	public void usingArraysSort(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() != s2.length())
			return;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();

		if (Arrays.equals(c1, c2)) {
			System.out.println("The given strings are anargram");
		} else {
			System.out.println("not anargram strings");
		}
	}

	public void usingHashMap(String s1, String s2) {
		System.out.println("using hashmap");

		if (s1 == null || s2 == null || s1.length() != s2.length())
			return;
		Map<Character, Integer> frequencyOfEachChar = new HashMap<>();
		for (char ch1 : s1.toCharArray()) {
			frequencyOfEachChar.put(ch1, frequencyOfEachChar.getOrDefault(ch1, 0) + 1);
		}
		System.out.println(frequencyOfEachChar);
		for (char ch2 : s2.toCharArray()) {
			if (!frequencyOfEachChar.containsKey(ch2)) {
				System.out.println("the given strings are not anargrams ");
				break;
			}
			frequencyOfEachChar.put(ch2, frequencyOfEachChar.get(ch2) - 1);
			if (frequencyOfEachChar.get(ch2) == 0) {
				frequencyOfEachChar.remove(ch2);
			}
			System.out.println(frequencyOfEachChar);
		}
		if (frequencyOfEachChar.isEmpty()) {
			System.out.println("The given strings are anargram");
		}

	}

	public void anargramStrings(String s1, String s2) {

		if (s1 == null || s2 == null || s1.length() != s2.length())
			return;
		boolean results = s1.chars().sorted().boxed().collect(Collectors.toList())
				.equals(s2.chars().sorted().boxed().collect(Collectors.toList()));
		if (results) {
			System.out.println("the given strings are anargram");
		} else {
			System.out.println("that strings are not anargram");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "anil";
		String s2 = "lina";
		Anargram an = new Anargram();
		an.usingArraysSort(s1, s2);
		an.usingHashMap(s1, s2);
		an.anargramStrings(s1, s2);

	}

}
