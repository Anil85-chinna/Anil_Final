package com.dsa.prefixsum;

import java.util.HashMap;
import java.util.Map;

public class CountSubarraysWhoseSumIsDivisibleByK {
	public void usingPreFixSum(int[] ar, int k) {
		int currentSum = 0;
		int module = 0;
		int count = 0;
		Map<Integer, Integer> storeHashMap = new HashMap<>();
		storeHashMap.put(0, 1);
		for (int i = 0; i < ar.length; i++) {
			currentSum = currentSum + ar[i];
			module = currentSum % k;
			if (module < 0) {
				module = module + k;
			}
			if (storeHashMap.containsKey(module)) {
				count = count + storeHashMap.get(module);
			}
			storeHashMap.put(module, storeHashMap.getOrDefault(module, 0) + 1);
		}
		System.out.println(" the count of sub arrays which is divisible by give number = " + count);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 4, 5, 0, -2, -3, 1 };
		int k = 5;
		CountSubarraysWhoseSumIsDivisibleByK cswsdk = new CountSubarraysWhoseSumIsDivisibleByK();
		cswsdk.usingPreFixSum(ar, k);

	}

}
