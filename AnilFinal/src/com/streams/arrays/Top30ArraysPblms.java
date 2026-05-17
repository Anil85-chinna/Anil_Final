package com.streams.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Top30ArraysPblms {

	// 1) Write a Java program to find duplicate elements in an array?
	public void usingSet() {
		int[] inputArray = new int[] { 111, 333, 555, 777, 333, 444, 555 };
		Set<Integer> duplicate = new HashSet<>();
		Set<Integer> storingDuplicates = new HashSet<>();
		for (Integer in : inputArray) {
			if (!duplicate.add(in)) {
				storingDuplicates.add(in);
			}
		}
		System.out.println(storingDuplicates);
		// i can also use haphmap each frequncy like that way
	}

	// 2) Write a Java program to find second largest element in an array of
	// integers?
	public void secondLargeElement() {
		System.out.println("2) Write a Java program to find second largest element in an array of integers?");
		int[] inputArray = new int[] { 111, 333, 555, 777, 333, 444, 555 };
		System.out.println("using streams");
		int secondHighstValue = Arrays.stream(inputArray).distinct().boxed().sorted(Comparator.reverseOrder())
				.mapToInt(Integer::intValue).skip(1).findFirst().getAsInt();
		System.out.println("the second highest number in array = " + secondHighstValue);
		/*
		 * public int secondHighest(int[] arr) { int first = Integer.MIN_VALUE; int
		 * second = Integer.MIN_VALUE; for (int num : arr) { if (num > first) { second =
		 * first; first = num; } else if (num > second && num != first) { second = num;
		 * } } return second; }
		 */

	}

	// given list of integer i need od and even using partitionby
	public void usingPartitionForOddAndEven() {
		List<Integer> ar = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
		Map<Boolean, List<Integer>> result = ar.stream()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0 ? true : false));
		System.out.println("even = " + result.get(true) + "Now odd = " + result.get(false));
	}

	// using reduce calculate the sum of int in array

	public void sumOfArrays() {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		int sum = Arrays.stream(ar).reduce(0, (a, b) -> a + b);
		System.out.println("the sum of array is = " + sum);
	}

	// find the max element in array using resuce
	public void maxElement() {
		int[] ar = { 1, 9, 3, 5, 4, 7, 8, 2, 6 };
		int maxValue = Arrays.stream(ar).reduce((a, b) -> a > b ? a : b).getAsInt();
		System.out.println("the max value is = " + maxValue);

		// same with method reference we can do
		int maxValues = Arrays.stream(ar).boxed().reduce(Integer::max).get();
		System.out.println("now using the method reference = " + maxValues);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Top30ArraysPblms tam = new Top30ArraysPblms();
		tam.usingSet();
		tam.secondLargeElement();
		tam.usingPartitionForOddAndEven();
		tam.sumOfArrays();
		tam.maxElement();

	}

}
