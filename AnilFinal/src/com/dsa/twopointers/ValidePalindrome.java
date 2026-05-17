package com.dsa.twopointers;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ValidePalindrome {

	// THIS IS FOR ONLY FOR NORMALE VALIDEPALINDROME
	public boolean Palindrome(String s) {
		s = s.toLowerCase();
		int start = 0, end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) {
				return false;
			}
			start++;
			end--;
		}
		return true;
	}

	// IF I NEED TO GO THROUNH THE LEETCODE ONLY FOR ALPHANUMERIC VALUES I NEED TO
	// CHECK PALINDROME ARE NOT
	public boolean isPalindrome(String s) {
		int start = 0, end = s.length() - 1;
		while (start < end) {
			char fchar = s.charAt(start);
			char echar = s.charAt(end);
			if (!Character.isLetterOrDigit(fchar)) {
				start++;
			} else if (!Character.isLetterOrDigit(echar)) {
				end--;
			} else {
				if (Character.toLowerCase(fchar) != Character.toLowerCase(echar)) {
					return false;
				}
				start++;
				end--;
			}
		}
		return true;
	}
//	THIS CODE IS WRITTEN BY MY SELF
//	 * public boolean validPalindrom(String s) {
//		int start = 0;
//		int end = s.length() - 1;
//		s = s.toLowerCase();
//		while (start < end) {
//			char fchar = s.charAt(start);
//			char echar = s.charAt(end);
//			if (!Character.isLetterOrDigit(fchar) && !Character.isLetterOrDigit(echar)) {
//				start++;
//				end--;
//			} else if (!Character.isLetterOrDigit(fchar) && Character.isLetterOrDigit(echar)) {
//				start++;
//			} else if (Character.isLetterOrDigit(fchar) && !Character.isLetterOrDigit(echar)) {
//				end--;
//			} else if (fchar == echar) {
//				start++;
//				end--;
//			} else {
//				return false;
//			}
//
//		}
//		return true;
//	}

	public void palindromUsingStreams(String str) {
		Boolean isPalindrom = IntStream.range(0, str.length() / 2).allMatch(i -> str.charAt(i) == str.charAt(str.length() - i - 1));
		if (isPalindrom) {
			System.out.println("the given string is palindrom");
		} else {
			System.out.println("the given string is not palindrom");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "madam";
		ValidePalindrome vp = new ValidePalindrome();
		System.out.println("The given string is " + vp.Palindrome(s) + " validwpalindrome");
		System.out.println("The given string is palindromr = " + vp.isPalindrome(s));
		vp.palindromUsingStreams(s);
	}

}
