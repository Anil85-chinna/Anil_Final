package com.dsa.twopointers;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseString {
	public void isReverseString(String[] s) {
		int left = 0, right = s.length - 1;
		while (left < right) {
			String temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			left++;
			right--;
		}
		System.out.println(Arrays.toString(s));
	}

	public void usingStream() {
		String str = "anil";
		String reversedString = IntStream.range(0, str.length()).mapToObj(i -> str.charAt(str.length() - 1 - i))
				.map(ch -> String.valueOf(ch)).collect(Collectors.joining());
		System.out.println(reversedString);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "h", "e", "l", "l", "o" };
		ReverseString rs = new ReverseString();
		rs.isReverseString(s);
		rs.usingStream();

	}

}
