package com.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumKPrefixHashMap {

	public void usingBruthForce(int[] ar, int k) {
		int sum = 0;
		int count = 0;
		for (int i = 0; i < ar.length; i++) {
			sum = 0;
			for (int j = i; j < ar.length; j++) {
				sum = sum + ar[j];
				if (k == sum) {
					count++;

				}
			}
		}
		System.out.println("the sub arrays count is = " + count);
	}

	public void usingPreFixSum(int[] ar, int k) {
		int currentSum = 0;
		int count = 0;
		int different = 0;
		Map<Integer, Integer> currentSumStore = new HashMap<>();
		currentSumStore.put(0, 1);
		for (int i = 0; i < ar.length; i++) {
			currentSum = currentSum + ar[i];
			different = currentSum - k;
			if (currentSumStore.containsKey(different)) {
				count = count + currentSumStore.get(different);

			}
			currentSumStore.put(currentSum, currentSumStore.getOrDefault(currentSum, 0) + 1);
		}
		System.out.println("The count is = " + count);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 1, 2, 3 };
		int k = 3;
		SubarraySumKPrefixHashMap sskph = new SubarraySumKPrefixHashMap();
		sskph.usingBruthForce(arr, k);
		sskph.usingPreFixSum(arr, k);

	}

}
