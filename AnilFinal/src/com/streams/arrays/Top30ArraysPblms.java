package com.streams.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

	// frequency of each element in array
	public void frequencyOfEachElement() {
		int[] ar = { 1, 2, 3, 5, 4, 6, 2, 1, 5, 3 };
		Map<Integer, Integer> frequencyMap = new HashMap<>();
		for (int a : ar) {
			frequencyMap.put(a, frequencyMap.getOrDefault(a, 0) + 1);
		}
		System.out.println("the frequency of each element in given array is " + frequencyMap);
		// now i am printing the duplicate elements
		System.out.println("now printing the duplicate values in array");
		for (Map.Entry<Integer, Integer> a : frequencyMap.entrySet()) {
			if (a.getValue() > 1) {
				System.out.println("the duplicate records = " + a.getKey() + " the frequncy = " + a.getValue());
			}
		}
	}

	public void usingStreams() {
		int[] ar = { 1, 2, 5, 3, 6, 4, 1, 2 };
		Map<Integer, Long> map = new HashMap<>();
		map = Arrays.stream(ar).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("using streams= " + map);
	}

	// printing the array in reverse order
	public void printArrayInReverse() {
		int[] ar = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		for (int i = ar.length - 1; i >= 0; i--) {
			System.out.print(ar[i]);
		}
	}

	public void usingStreamInreversOrder() {
		int[] ar = { 6, 5, 4, 3, 2, 1 };
		System.out.println("using stream i am printing in reverse order");
		IntStream.range(0, ar.length).forEach(i -> System.out.println(ar[ar.length - 1 - i]));
	}

	// in streams we can also use ITERATOR
	public void usingIterator() {
		int[] ar = { 3, 2, 1 };
		IntStream.iterate(ar.length - 1, i -> i >= 0, i -> i - 1).forEach(i -> System.out.print(ar[i]));
	}

	// find the largestelement
	public void largestAndSmallElement() {
		int[] ar = { 1, 9, 2, 36 };
		int largestElement = Integer.MIN_VALUE;
		int smallestElement = Integer.MAX_VALUE;
		for (int a : ar) {
			if (a > largestElement) {
				largestElement = a;
			}
		}
		System.out.println("the largest element in array is = " + largestElement);

		for (int a : ar) {
			if (a < smallestElement) {
				smallestElement = a;
			}
		}
		System.out.println("the smallestElement is = " + smallestElement);
	}

	public void usingStreamsLargestAndSmallestElement() {
		int[] ar = { 10, 58, 36, 95, 100 };
		int largeElement = Arrays.stream(ar).boxed().sorted(Comparator.reverseOrder()).findFirst().get();
		System.out.println("the large element is = " + largeElement);
		int smallestElement = Arrays.stream(ar).boxed().sorted().findFirst().get();
		System.out.println("the small element using streams = " + smallestElement);
		/*
		 * 
		 * // Maximum value int max = Arrays.stream(arr) .max() .getAsInt();
		 * 
		 * // Minimum value int min = Arrays.stream(arr) .min() .getAsInt();
		 */
	}

	// print the sum of all elements
	public void sumOfAllElements() {
		int[] ar = { 1, 2, 3, 4, 5, 6 };
		int sum = 0;
		for (int a : ar) {
			sum = sum + a;
		}
		System.out.println("the sum of all elements is = " + sum);
		int streamSum = Arrays.stream(ar).sum();
		System.out.println("the sum using stream is  = " + streamSum);
	}

	// sort the elements in accending order
	// here we are not able to use the comparator and comparable.. becoz those are
	// used only on objects not in premitive types.
	public void sortArray() {
		int[] ar = { 1, 2, 5, 3, 6, 4 };
		for (int i = 0; i <= ar.length - 1; i++) {
			for (int j = i + 1; j <= ar.length - 1; j++) {
				if (ar[i] > ar[j]) {
					int temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		for (int a : ar) {
			System.out.print(a + " ");
		}

		int[] ar1 = Arrays.stream(ar).sorted().toArray();
		System.out.println("using streams sorted the array = ");
		Arrays.stream(ar1).forEach(e -> System.out.print(e + " "));
		System.out.println("\n now using two pointers approch");
		int start = 0;
		int end = ar.length - 1;
		while (start < end) {
			if (ar[start] > ar[end]) {
				int temp = ar[start];
				ar[start] = ar[end];
				ar[end] = temp;
				start++;
				end--;
			} else {
				start++;
				end--;
			}
		}
		for (int a1 : ar) {
			System.out.print(" " + a1);
		}
		System.out.println();

	}

	// seperate obb and even numbers
	public void seperateOddAndEven() {
		int[] ar = { 1, 2, 3, 4, 5, 6 };
		int[] odd = new int[ar.length];
		int oddCount = 0;
		int evenCount = 0;
		int[] even = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] % 2 == 0) {
				even[evenCount] = ar[i];
				evenCount++;
			} else {
				odd[oddCount] = ar[i];
				oddCount++;
			}
		}
		for (int od : odd) {
			System.out.print(od + "-");
		}
		for (int ev : even) {
			System.out.print(ev + "-");
		}

		System.out.println("using streams");
		Map<Boolean, List<Integer>> resultMap = Arrays.stream(ar).boxed()
				.collect(Collectors.partitioningBy(i -> i % 2 == 0 ? true : false));
		System.out.println(resultMap);
		System.out.println("now using twopointers approch");
	}

	public void smallestPositiveInteger(int[] ar) {
		int smallestNumber = 1;
		Set<Integer> set = new HashSet<>();
		for (int num : ar) {
			if (num > 0) {
				set.add(num);
			}
		}
		while (set.contains(smallestNumber)) {
			smallestNumber++;
		}

		System.out.println("the smallest positive integer is = " + smallestNumber);
	}

	// sort array in decending order
	public void usingStreams(int[] ar) {
		int[] result = Arrays.stream(ar).sorted().toArray();
		for (int a : result) {
			System.out.print(a + " ");
		}
	}

	// Find sum of digits in a given string ?
	public void sumOfNumberInString() {
		String str = "a2a5a3a6a5a1";
		int sumOfGivenNumbersInString = str.chars().mapToObj(ch -> (char) ch).filter(c -> Character.isDigit(c))
				.map(el -> String.valueOf(el)).mapToInt(e -> Integer.parseInt(e)).sum();
		System.out.println("sumOfGivenNumbersInString => " + sumOfGivenNumbersInString);
	}

	// Q7. Generate the largest number possible using these digits ?
	public void larsetNumber() {
		int[] ar = { 4, 2, 1, 3 };
		String number = Arrays.stream(ar).boxed().sorted(Comparator.reverseOrder()).map(num -> String.valueOf(num))
				.collect(Collectors.joining());
		System.out.println("the number formed with given digits = " + Integer.parseInt(number));
	}
	/*
	 * Option 1: a before b a + b = "54" + "546" = "54546" Option 2: b before a b +
	 * a = "546" + "54" = "54654"
	 * 
	 * Now compare:
	 * 
	 * "54654".compareTo("54546") 54654 > 54546
	 * 
	 * compareTo() returns a positive value.
	 * 
	 * Therefore:
	 * 
	 * 546 should come before 54 Another Example a = "60" b = "548" Option 1 a + b =
	 * "60548" Option 2 b + a = "54860"
	 * 
	 * Compare:
	 * 
	 * "60548".compareTo("54860")
	 * 
	 * Since:
	 * 
	 * 60548 > 54860
	 * 
	 * 60 should come before 548. ["54", "546", "548", "60"]
	 * 
	 * Comparisons:
	 * 
	 * a b a+b b+a Winner 54 546 54546 54654 546 546 548 546548 548546 548 548 60
	 * 54860 60548 60
	 * 
	 * Final order:
	 * 
	 * ["60", "548", "546", "54"]
	 */

	public void largenumber() {
		int[] ar = { 54, 546, 548, 60 };
		String large = Arrays.stream(ar).boxed().map(t -> String.valueOf(t)).sorted((a, b) -> (b + a).compareTo(a + b))
				.collect(Collectors.joining());
		System.out.println(large);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Top30ArraysPblms tam = new Top30ArraysPblms();
		tam.usingSet();
		tam.secondLargeElement();
		tam.usingPartitionForOddAndEven();
		tam.sumOfArrays();
		tam.maxElement();
		tam.frequencyOfEachElement();
		tam.usingStreams();
		tam.printArrayInReverse();
		tam.usingStreamInreversOrder();
		tam.usingIterator();
		tam.largestAndSmallElement();
		tam.usingStreamsLargestAndSmallestElement();
		tam.sumOfAllElements();
		tam.sortArray();
		tam.seperateOddAndEven();
		int[] ar = { 1, 2, 0 };
		tam.smallestPositiveInteger(ar);
		tam.usingStreams(ar);
		tam.sumOfNumberInString();
		tam.larsetNumber();
		tam.largenumber();

	}

}
