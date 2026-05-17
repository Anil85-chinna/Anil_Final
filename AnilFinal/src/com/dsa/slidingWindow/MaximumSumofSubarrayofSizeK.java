package com.dsa.slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class MaximumSumofSubarrayofSizeK {

	public void slidingWindowImpl(int size, int[] ar) {
		int end = ar.length;
		int intialWindowSum = 0;

		for (int i = 0; i < size; i++) {
			intialWindowSum = intialWindowSum + ar[i];
			System.out.println("1-> " + intialWindowSum);
		}
		int maxValue = intialWindowSum;
		for (int i = size; i < end; i++) {
			intialWindowSum = intialWindowSum - ar[i - size] + ar[i];
			System.out.println("2 -> " + intialWindowSum);
			maxValue = Math.max(maxValue, intialWindowSum);
			System.out.println("3 -> " + maxValue);
		}
		System.out.println("the maximumsum of subarray of size give is " + size + " = " + maxValue);

	}

	public void sliding(int size, int[] ar) {
		int winSum = 0;
		int start = 0;
		int maxValue = 0;
		for (int i = 0; i < ar.length; i++) {

			winSum = winSum + ar[i];

			if (i - start + 1 > size) {
				winSum = winSum - ar[start];
				start++;
			}
			if (i - start + 1 == size) {
				maxValue = Math.max(maxValue, winSum);
			}
		}
		System.out.println("The max values is = " + maxValue);

	}

	public void slidingWindowImplWithDistintValues(int size, int[] arr) {
		int sum = 0;
		int maxValue = 0;
		int start = 0;
		Set<Integer> setInput = new HashSet<>();
		for (int i = 0; i < arr.length; i++) {
			while (setInput.contains(arr[i])) {
				sum = sum - arr[start];
				setInput.remove(arr[start]);
				start++;
			}
			sum = sum + arr[i];
			setInput.add(arr[i]);

			if (i - start + 1 > size) {
				sum = sum - arr[start];
				start++;
				setInput.remove(arr[start]);
			}
			if (i - start + 1 == size) {
				maxValue = Math.max(maxValue, sum);
			}
		}
		System.out.println("The max sum with uniqe values " + maxValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 2, 1, 5, 1, 3, 2 };
		int k = 3;
		MaximumSumofSubarrayofSizeK msss = new MaximumSumofSubarrayofSizeK();
		msss.slidingWindowImpl(k, arr);
		msss.slidingWindowImplWithDistintValues(k, arr);
		msss.sliding(k, arr);
	}

}
