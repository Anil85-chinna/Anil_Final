package com.practice;

import java.util.HashMap;
import java.util.Map;

public class PracticeOne {

	public int[] twoSum(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int[] result = new int[2];
		while (start < end) {
			int sum = ar[start] + ar[end];
			if (sum == target) {
				System.out.println("results are = " + start + " " + end);
				return new int[] { start, end };
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}
		}
		return new int[] { -1, -1 };
	}

	public int[] usingHasMap(int[] ar, int target) {
		Map<Integer, Integer> resMap = new HashMap<>();
		System.out.println(resMap);
		for (int i = 0; i < ar.length; i++) {
			int remainder = target - ar[i];
			if (resMap.containsKey(remainder)) {
				return new int[] { resMap.get(remainder), i };
			} else {
				resMap.put(ar[i], i);
			}
		}
		return new int[] { -1, -1, };
	}

	public boolean validPalindrom(String s) {
		int start = 0;
		int end = s.length() - 1;
		s = s.toLowerCase();
		while (start < end) {
			char fchar = s.charAt(start);
			char echar = s.charAt(end);
			if (!Character.isLetterOrDigit(fchar) && !Character.isLetterOrDigit(echar)) {
				start++;
				end--;
			} else if (!Character.isLetterOrDigit(fchar) && Character.isLetterOrDigit(echar)) {
				start++;
			} else if (Character.isLetterOrDigit(fchar) && !Character.isLetterOrDigit(echar)) {
				end--;
			} else if (fchar == echar) {
				start++;
				end--;
			} else {
				return false;
			}

		}
		return true;
	}
	
	public boolean palindrom(String str) {
		int start=0;
		int end=str.length()-1;
		while(start<end) {
			char fchar=str.charAt(start);
			char lchar=str.charAt(end);
			if(!Character.isLetterOrDigit(fchar)) {
				start++;
			}else if(!Character.isLetterOrDigit(lchar)) {
				end--;
			}else {
				if(Character.toLowerCase(fchar)!=Character.toLowerCase(lchar)) {
					return false;
				}else {
					start++;
					end--;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PracticeOne p = new PracticeOne();
		int[] ar = { 2, 7, 11, 15 };
		int tar = 9;
		int[] res = p.twoSum(ar, tar);
		int[] resHas = p.usingHasMap(ar, tar);
		System.out.println("using hashmap = " + resHas[0] + " " + resHas[1]);
		String str = "A man, a plan, a canl: Panama";
		boolean result = p.validPalindrom(str);
		System.out.println("the valide palindrome is = " + result);
	}

}
