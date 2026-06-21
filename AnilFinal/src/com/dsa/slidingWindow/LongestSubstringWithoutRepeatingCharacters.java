package com.dsa.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

	// while duplicate:
	// remove left start++
	// add current currentLength=i-start+1 max=
	// max(max, currentLength)

	public void usingSlidingWindow(String s) {
		int slen = s.length();
		int start = 0;
		int subStringLength = 0;
		int maxValue = 0;
		//int bestStart = 0;
		Set<Character> storeCharSet = new HashSet<>();
		char[] charArray = s.toCharArray();
		for (int i = 0; i < slen; i++) {
			while (storeCharSet.contains(charArray[i])) {
				// subStringLength = i - start - 1; this is not required like after removeing
				// from left we are increassing the start value. So in adding value start will
				// update autometically.. other wise we can do it manually.. start increases =
				// window shrinks
				storeCharSet.remove(charArray[start]);
				start++;
			}
			storeCharSet.add(charArray[i]);
			subStringLength = i - start + 1;
			/*
			 * Yes — technically you can use Math.max() for the length, but in this specific
			 * place it is not sufficient alone because you also need to update bestStart.
			 * Short Answer For only length: maxValue = Math.max(maxValue, subStringLength);
			 * ✅ Works. But when you also need substring output, you must know when max
			 * changed, so you can store: bestStart = start; That’s why if is better here.
			 */
			// THIS BELOW LINE IS ONLY SUITABLE TO FIND THE MAX LENGTH OF SUBSTRING. BUT IF
			// WE NEED THAT SUBSTRING IT NOT WORK
			// maxValue = Math.max(maxValue, subStringLength);
			if (subStringLength > maxValue) {
				maxValue = subStringLength;
				//bestStart = start;
			}
		}
		//System.out.println("we are printing the that substring also = " + s.substring(bestStart, bestStart + maxValue));
		System.out.println("the max length of substring nonrepeating chars = " + maxValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestSubstringWithoutRepeatingCharacters obj = new LongestSubstringWithoutRepeatingCharacters();

		obj.usingSlidingWindow("abcabcbb"); // Expected: 3
		obj.usingSlidingWindow("bbbbb"); // Expected: 1
		obj.usingSlidingWindow("pwwkew"); // Expected: 3
		obj.usingSlidingWindow("abba"); // Expected: 2
		obj.usingSlidingWindow("abcdef"); // Expected: 6
		obj.usingSlidingWindow(""); // Expected: 0
		obj.usingSlidingWindow("dvdf"); // Expected: 3

	}

}
