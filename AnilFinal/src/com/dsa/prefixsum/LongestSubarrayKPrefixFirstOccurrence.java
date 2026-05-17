package com.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayKPrefixFirstOccurrence {
	public void usingBruthForce(int[] ar, int k) {
		int sum = 0;
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < ar.length; i++) {
			int count = 0;
			sum = 0;
			for (int j = i; j < ar.length; j++) {
				sum = sum + ar[j];
				if (sum == k) {
					count = j - i + 1;
				}
			}
			max = Math.max(max, count);
		}
		System.out.println("the longestsubaray is = " + max);
	}

	public void usingPrefixSum(int[] ar, int k) {
		int currentSum = 0;
		int max = Integer.MIN_VALUE;
		int difference = 0;
		int length = 0;
		Map<Integer, Integer> storeFirstOccurence = new HashMap<>();
		storeFirstOccurence.put(0, -1);

		for (int i = 0; i < ar.length; i++) {
			currentSum = currentSum + ar[i];
			difference = currentSum - k;
			if (storeFirstOccurence.containsKey(difference)) {
				length = i - storeFirstOccurence.get(difference);
				max = Math.max(max, length);
			}
			if (!storeFirstOccurence.containsKey(currentSum)) {
				storeFirstOccurence.put(currentSum, i);
			}
		}
		System.out.println("the longest sunarray length = " + max);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 3, 1, 1, 1, 1 };
		int k = 6;
		LongestSubarrayKPrefixFirstOccurrence lskpfo = new LongestSubarrayKPrefixFirstOccurrence();
		lskpfo.usingBruthForce(ar, k);
		lskpfo.usingPrefixSum(ar, k);

	}

}
