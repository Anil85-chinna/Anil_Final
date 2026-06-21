package com.streams.strings;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Top25FrequentlyAskedStringQuestion {

	// 1) Write a Java program to find the duplicate words and their number of
	// occurrences in a string?
	public void duplicateWordsUsingForLoop(String str) {
		System.out.println("1) Write a Java program to find the duplicate words and their number of");
		Map<String, Integer> frequencyOfEachWordInString = new HashMap<>();
		for (String s : str.split(" ")) {
			// System.out.println(s);
			frequencyOfEachWordInString.put(s, frequencyOfEachWordInString.getOrDefault(s, 0) + 1);
		}
		System.out.println(frequencyOfEachWordInString);
	}

	// now using streams
	public void duplicateWordsUsingStreams(String str) {
		Map<String, Long> frequencyOfEachWords = new HashMap<>();
		frequencyOfEachWords = Stream.of(str.split("\\s+"))
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println(frequencyOfEachWords);
	}

	// 2) Write a Java program to count the number of words in a string?
	/*
	 * Why \\s+? \\s → any whitespace (space, tab, newline) + → one or more Prevents
	 * empty elements
	 */
	public void countOfWordsUsingLoops(String str) {
		System.out.println("2) Write a Java program to count the number of words in a string?");
		int count = 0;
		for (String st : str.split("\\s+")) {
			count = count + 1;
		}
		System.out.println("the total words in given string is " + count);
	}

	public void countOFWordsUsingStream(String s) {
		Long count = Stream.of(s.split("\\s+")).count();
		System.out.println("The count of words in given string " + count);
	}

	// 3) Write a Java program to count the total number of occurrences of a given
	// character in a string without using any loop?
	public void countOfGivenCharInString(String s, char c) {
		System.out.println(
				"3) Write a Java program to count the total number of occurrences of a given character in a string without using any loop?");
		int countOfGivenChar = s.length() - s.replace(String.valueOf(c), "").length();
		System.out.println("The occurence of given char is " + countOfGivenChar);
	}

	public void countOfGivenCharInStringUsingStreams(String s, char c) {
		Long countOfGivenCharInString = s.chars().filter(ch -> ch == c).count();
		System.out.println("The count of char in given string is " + countOfGivenCharInString);
	}

	// 4) Write a java program to reverse a string?
	public void usingTwoPointers(String s) {
		System.out.println("4) Write a java program to reverse a string?");
		if (s == null || s.length() <= 1) {
			System.out.println(s);
			;
		}
		int start = 0;
		int end = s.length() - 1;
		char[] charArray = s.toCharArray();
		while (start < end) {
			char tempChar = charArray[start];
			charArray[start] = charArray[end];
			charArray[end] = tempChar;
			start++;
			end--;
		}
		System.out.println("the string is reversed " + String.valueOf(charArray));
	}

	public void usingStreamsForReverseString(String s) {
		String reversedString = IntStream.range(0, s.length())
				.mapToObj(i -> String.valueOf(s.charAt(s.length() - 1 - i))).collect(Collectors.joining());
		// .reduse("",(a,b)-> a+b);
		System.out.println("we reversed the string using streams= " + reversedString);
	}

	// 5) Write a Java program to count the number of occurrences of each character
	// in a string?
	public void FreqencyOfEachCharusingLoop(String s) {
		System.out.println("5) Write a Java program to count the number of occurrences of each character in a string?");
		Map<Character, Integer> frequencyOfEachChar = new HashMap<>();
		for (char c : s.toCharArray()) {
			frequencyOfEachChar.put(c, frequencyOfEachChar.getOrDefault(c, 0) + 1);
		}
		System.out.println("the frequncy of each char is = " + frequencyOfEachChar);
	}

	public void FreqencyOfEachCharusingStreams(String s) {
		Map<Character, Long> frequencyOfEachChar = new HashMap<>();
		frequencyOfEachChar = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
		System.out.println("using streams = " + frequencyOfEachChar);
	}

	// 6) Write a Java program to remove all white spaces from a string?
	public void removingWhiteSpaces(String s) {
		s = s.replaceAll("\\s+", "");
		System.out.println("after removing the white spaces in string " + s);
	}

	public void removingSpaceWithLoop(String s) {
		char[] ch = s.toCharArray();
		StringBuffer outputString = new StringBuffer();
		for (char c : ch) {
			if (c != ' ' && c != '\t') {
				outputString = outputString.append(String.valueOf(c));
			}
		}
		System.out.println("string with out spaces are " + outputString);
	}

//7) Write a Java program to find duplicate characters in a string?
	public void duplicateCharsInString(String s) {
		Map<Character, Long> frequencyOfEachChar = new HashMap<>();
		frequencyOfEachChar = s.chars().mapToObj(c -> (char) c)
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting())).entrySet().stream()
				.filter(entrySet -> entrySet.getValue() > 1)
				.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		System.out.println("using streams = " + frequencyOfEachChar);
		/*
		 * public class DuplicateCharacters {
		 * 
		 * public static void main(String[] args) { String input = "programming";
		 * 
		 * printDuplicateChars(input); }
		 * 
		 * public static void printDuplicateChars(String str) { Set<Character> seen =
		 * new HashSet<>(); Set<Character> duplicates = new HashSet<>();
		 * 
		 * for (char ch : str.toCharArray()) { if (!seen.add(ch)) { // already exists
		 * duplicates.add(ch); // store only once } }
		 * 
		 * System.out.println("Duplicate characters: " + duplicates); } }
		 */
	}

	// 8) Write a Java program to check whether one string is a rotation of another?
	public void rotationOfOtherString(String s1, String s2) {
		System.out.println("8) Write a Java program to check whether one string is a rotation of another?");
//		if (s1 == null || s2 == null) {
//			return;
//		}
//		if (s1.length() != s2.length()) {
//			return;
//		}
		String s3 = s1 + s1;
		if (s3.contains(s2)) {
			System.out.println("the second string is rotation of first string");
		} else {
			System.out.println("nothing");
		}
	}

	// 10) Write a Java program to reverse a given string with preserving the
	// position of spaces?
	public void usingTwoPointerApprochReverseStringWithMaintainSpace(String s) {
		System.out.println("10) Write a Java program to reverse a given string with preserving the");
		if (s == null || s.length() < 1) {
			System.out.println(s);
		}
		int start = 0;
		int end = s.length() - 1;
		char[] ch = s.toCharArray();
		while (start <= end) {
			if (ch[start] == ' ') {
				start++;
			} else if (ch[end] == ' ') {
				end--;
			} else {
				char tempChar = ch[start];
				ch[start] = ch[end];
				ch[end] = tempChar;
				start++;
				end--;
			}
		}
		System.out.println("the string reversed with maintaining the spaces =" + String.valueOf(ch));
	}

	// 11) Write a Java program to reverse each word of a given string?
	public void reverseEachWordInGivenString(String s) {
		System.out.println(" 11) Write a Java program to reverse each word of a given string?");
		if (s == null || s.trim().isEmpty()) {
			return;
		}

		StringBuilder result = new StringBuilder();
		for (String eachWord : s.split("\\s+")) {
			char[] eachWordCharArray = eachWord.toCharArray();
			int start = 0;
			int end = eachWord.length() - 1;
			while (start < end) {
				char tempChar = eachWordCharArray[start];
				eachWordCharArray[start] = eachWordCharArray[end];
				eachWordCharArray[end] = tempChar;
				start++;
				end--;
			}
			result.append(eachWordCharArray).append(" ");
		}
		System.out.println("the output is after reversing each word in given string = " + result);
	}

	public void usingStreamReverseEachWordInGivenString(String s) {
		String reversedString = Stream.of(s.split("\\s+")).map(word -> new StringBuilder(word).reverse())
				.collect(Collectors.joining(" "));
		System.out.println("using streams =" + reversedString);
	}

	// code for showing string is immutable
	public void immutableString() {
		String str = "anil";
		System.out.println(System.identityHashCode(str));
		str.concat("vemula");
		System.out.println(str);
		String str1 = str.concat("second");
		System.out.println(str1);
		System.out.println(System.identityHashCode(str1));
	}

	// removing the leading zeros from the given string
	public void usingTwoPointers() {
		String str = "00000";
		int start = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(start) == '0') {
				start++;
			}
		}
		System.out.println("the start value is " + start + "the length of string" + str.length());
		System.out.println("the word after removing the leading zeros = " + str.substring(start));
	}
	// input: aabbccdd
	// output: a2b2c2d2

	public void countOfEachCharinString() {
		String str = "aabbccdde";
		int count = 1;
		StringBuffer result = new StringBuffer();
		int strLen = str.length() - 1;
		for (int i = 0; i < strLen; i++) {
			if (str.charAt(i) != str.charAt(i + 1)) {
				result.append(str.charAt(i)).append(count);
				count = 1;
			} else {
				count++;
			}
		}
		result.append(str.charAt(strLen)).append(count);
		System.out.println("the output string is = " + result);
	}

	// Count the number of matching character in the pair of the string ?
	public int countOfMatchingCharinGivenPairOfStrings() {
		String str1 = "anil";
		String str2 = "chinna";
		int count = 0;
		Set<Character> charsSet = new HashSet<>();
		for (char ch : str1.toCharArray()) {
			charsSet.add(ch);
		}
		for (char ch2 : str2.toCharArray()) {
			if (charsSet.contains(ch2)) {
				count++;
				charsSet.remove(ch2);
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strWithDuplicateWords = "Java is powerful and Java is scalable and Java is widely used in enterprise applications";
		Top25FrequentlyAskedStringQuestion t25 = new Top25FrequentlyAskedStringQuestion();
		t25.duplicateWordsUsingForLoop(strWithDuplicateWords);
		t25.duplicateWordsUsingStreams(strWithDuplicateWords);
		t25.countOfWordsUsingLoops(strWithDuplicateWords);
		t25.countOFWordsUsingStream(strWithDuplicateWords);
		t25.countOfGivenCharInString(strWithDuplicateWords, 'a');
		t25.countOfGivenCharInStringUsingStreams(strWithDuplicateWords, 'b');
		t25.usingTwoPointers("anil");
		t25.usingStreamsForReverseString("anila");
		t25.FreqencyOfEachCharusingLoop("123123123");
		t25.FreqencyOfEachCharusingStreams("2525");
		t25.removingWhiteSpaces("sc sdv     sdfm sdvs");
		t25.removingSpaceWithLoop(strWithDuplicateWords);
		t25.duplicateCharsInString(strWithDuplicateWords);
		String s1 = "anil";
		String s2 = "ila";
		t25.rotationOfOtherString(s1, s2);
		t25.usingTwoPointerApprochReverseStringWithMaintainSpace("1 22 333 4444 55555");
		t25.reverseEachWordInGivenString("Reverse Me");
		t25.usingStreamReverseEachWordInGivenString("I am string not reversed");
		t25.immutableString();
		t25.usingTwoPointers();
		t25.countOfEachCharinString();
		System.out.println("the count of matching chars in given pair of strings = "
				+ t25.countOfMatchingCharinGivenPairOfStrings());
	}
}
