package com.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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
		System.out.println("Filter even numbers from a List");
		List<Integer> list = Arrays.asList(1, 2, 3, 5, 4, 6, 9, 7, 8);
		Map<String, List<Integer>> EvenAndOdd = list.stream()
				.collect(Collectors.groupingBy(num -> num % 2 == 0 ? "Even" : "Odd"));
		System.out.println("the even numbers = " + EvenAndOdd.get("Even"));
		System.out.println("the odd numbers = " + EvenAndOdd.get("Odd"));

		System.out.println("NOW USING PARTITION BY");
		Map<Boolean, List<Integer>> usingPartitionBy = list.stream()
				.collect(Collectors.partitioningBy(num -> num % 2 == 0 ? true : false));
		System.out.println("results = " + usingPartitionBy);
		System.out.println("the even numbers = " + usingPartitionBy.get(true));
		System.out.println("the odd numbers = " + usingPartitionBy.get(false));
		List<Integer> usingConcat = Stream
				.concat(list.stream().filter(num -> num % 2 == 0), list.stream().filter(num2 -> num2 % 2 != 0))
				.toList();
		System.out.println("using concat list == " + usingConcat);

		// sort the list
		List<Integer> list1 = Arrays.asList(5, 2, 1, 4, 6, 3);
		list1.stream().sorted().forEach(System.out::print);
		list1.stream().sorted(Comparator.reverseOrder()).forEach(System.out::print);
		list1.stream().sorted((a, b) -> a - b).forEach(System.out::print);// ACCENDING ORDER
		list1.stream().sorted((a, b) -> b - a).forEach(System.out::print);// DECENDING ORDER

		// REVERSE LIST
		System.out.println("\n REVERSE A LIST");
		List<Integer> list2 = Arrays.asList(5, 2, 5, 8, 2, 9);
		// IntStream.range(0, list2.size()).forEach(i ->
		// System.out.print(list2.get(list2.size() - i - 1)+" ")); --> NOT THAT MUCH
		// RECOMMANDED
		IntStream.range(0, list2.size()).mapToObj(i -> list2.get(list2.size() - i - 1)).forEach(System.out::print);
		IntStream.iterate(list2.size() - 1, i -> i >= 0, i -> i = i - 1).mapToObj(list2::get)
				.forEach(System.out::print);

		// convertint to upercase
		List<String> names = Arrays.asList("Java", "Spring", "Microservices", "API");
		System.out.println();
		names.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

		// i need to print first names from full names
		List<String> name = Arrays.asList("Anil", "Sai Kiran", "Ravi Teja", "Srinivas Reddy");
		List<String> result = name.stream().map(str -> str.split(" ")).map(r -> r[0]).collect(Collectors.toList());
		System.out.println(result);
		// using index of
		List<String> result1 = name.stream().map(str -> {
			int firstSpace = str.indexOf(" ");
			if (firstSpace == -1) {
				return str;
			}
			String firstName = str.substring(0, firstSpace);
			return firstName;
		}).collect(Collectors.toList());
		System.out.println(result1);

		// List to set
		System.out.println("LIST TO SET");
		Set<Integer> ListToSet = list2.stream().collect(Collectors.toCollection(HashSet::new));// we need to tell that
																								// like which set we
																								// need to use becoz Set
																								// is the interface so
																								// we can directly use
																								// COLLECTORS.TOSET();
		System.out.println(ListToSet);

	}

}
