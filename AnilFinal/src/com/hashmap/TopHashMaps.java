package com.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopHashMaps {
	// 4) How do you extract a list of only keys or a list of only values or a list
	// of all entries from a given HashMap?
	public void sampleExcersice() {
		HashMap<Integer, String> studentIdNameMap = new HashMap<Integer, String>();
		studentIdNameMap.put(111, "Joshua Helfhanaus");
		studentIdNameMap.put(222, "Vedant Joshi");
		studentIdNameMap.put(333, "Ben Mitchael");
		studentIdNameMap.put(444, "Poorvi Shah");
		studentIdNameMap.put(555, "Wnag Chama");
		System.out.println("only printing the entry sets in hashmap ");
		for (Map.Entry<Integer, String> entrySet : studentIdNameMap.entrySet()) {
			System.out.println(entrySet);
		}
		studentIdNameMap.entrySet().stream().forEach(System.out::println);

		System.out.println("now printing only keys");
		for (Integer in : studentIdNameMap.keySet()) {
			System.out.println(in);
		}
		studentIdNameMap.keySet().stream().forEach(System.out::println);
		System.out.println("now only values");
		for (String s : studentIdNameMap.values()) {
			System.out.println(s);
		}
		studentIdNameMap.values().stream().forEach(System.out::println);
	}

	public void maxFrequencyNumberInArray() {
		int[] inputArray = { 4, 7, 2, 9, 1, 7, 1, 4, 7, 8 };
		Map<Integer, Integer> frequncyMap = new HashMap<>();
		int maxCount = 0;
		for (Integer in : inputArray) {
			frequncyMap.put(in, frequncyMap.getOrDefault(in, 0) + 1);
			if (maxCount < frequncyMap.get(in)) {
				maxCount = frequncyMap.get(in);
			}
		}
		System.out.println(maxCount);
		System.out.println(frequncyMap);
		for (Map.Entry<Integer, Integer> inte : frequncyMap.entrySet()) {
			if (inte.getValue().equals(maxCount)) {
				System.out.println(inte.getKey());
			}
		}
		System.out.println("now using streams");
		frequncyMap.entrySet().stream().max(Map.Entry.comparingByValue())
				.ifPresent(entry -> System.out.println(entry.getKey()));
		// now i am printing 2 most repeating value
		int secondMaxNumber = frequncyMap.entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).skip(1).findFirst().get().getKey();
		System.out.println(secondMaxNumber);
	}

	// 15) Given an array of strings, group anagrams together in a HashMap?
	public void groupOfAnargram() {
		String[] strArray = { "Bat", "Silent", "Tea", "Race", "Tab", "Acre", "Eat", "Care", "Listen", "Earth", "Ate",
				"Enlist", "Heart", };
		Map<String, List<String>> anargramMap = new HashMap<>();
		List<String> arList = new ArrayList<>();
		for (String str : strArray) {
			char[] charArray = str.toLowerCase().toCharArray();
			Arrays.sort(charArray);
			String sortedArray = new String(charArray);
			if (anargramMap.containsKey(sortedArray)) {
				// Key already exists → add to existing list
				anargramMap.get(sortedArray).add(str);
			} else {

				arList.add(str);
				anargramMap.put(sortedArray, arList);
			}
		}
		System.out.println("using if else condition = " + anargramMap);
	}

	public void groupOfAnargramInSimpleBuiltIN() {
		System.out.println("using builtin mthods");
		String[] strArray = { "Bat", "Silent", "Tea", "Race", "Tab", "Acre", "Eat", "Care", "Listen", "Earth", "Ate",
				"Enlist", "Heart", };
		Map<String, List<String>> anargramMap = new HashMap<>();
		for (String str : strArray) {
			char[] charAr = str.toLowerCase().toCharArray();
			Arrays.sort(charAr);
			String sortedString = new String(charAr);
			anargramMap.putIfAbsent(sortedString, new ArrayList<String>());
			anargramMap.get(sortedString).add(str);
		}
		System.out.println("using builtin method=" + anargramMap);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopHashMaps thm = new TopHashMaps();
		thm.sampleExcersice();
		thm.maxFrequencyNumberInArray();
		thm.groupOfAnargram();
		thm.groupOfAnargramInSimpleBuiltIN();

	}

}
