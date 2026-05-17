package com.dsa.twopointers;

import java.util.Arrays;

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

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] s = { "h", "e", "l", "l", "o" };
		ReverseString rs = new ReverseString();
		rs.isReverseString(s);

	}

}
