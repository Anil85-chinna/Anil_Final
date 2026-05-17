package com.dsa.slidingWindow;

public class MinimumSizeSubarraySum {

	public void usingSlidingWIndow(int target, int[] ar) {
		int windowSum = 0;
		int start = 0;
		int minlen = 0;
		int subArrayLen = Integer.MAX_VALUE;
		for (int end = 0; end < ar.length; end++) {
			windowSum = windowSum + ar[end];
			minlen = end - start + 1; // in this we are increading the length of the minlen attribute
			while (windowSum >= target) {
				minlen = end - start + 1; // inthis place start value is increasing so according to the wr are decresing
											// the length of the minlen attribute right?
				subArrayLen = Math.min(minlen, subArrayLen);
				windowSum = windowSum - ar[start];
				start++;
			}
		}
		System.out.println("The minimum length of subarray is = " + subArrayLen);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
		int target = 11;
		int[] ar = { 1, 2, 3, 4, 5 };
		msss.usingSlidingWIndow(target, ar);

	}

}
