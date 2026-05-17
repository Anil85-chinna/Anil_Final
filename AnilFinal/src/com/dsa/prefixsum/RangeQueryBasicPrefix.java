package com.dsa.prefixsum;

public class RangeQueryBasicPrefix {

	public void usingPrefixSum(int[] ar, int left, int right) {
		int[] prefixSumArray = new int[ar.length];
		if (ar == null || ar.length == 0) {
			throw new IllegalArgumentException("Array is empty ");
		}
		prefixSumArray[0] = ar[0];
		for (int i = 1; i < ar.length; i++) {
			prefixSumArray[i] = prefixSumArray[i - 1] + ar[i];
		}
		// step two for range specific
		int sum = 0;
		if (left < 0 || right > ar.length || left > right) {
			throw new IllegalArgumentException("Invalid Range");
		}

		if (left == 0) {
			sum = prefixSumArray[right];
		} else {
			sum = prefixSumArray[right] - prefixSumArray[left - 1];
		}
		System.out.println("the sum of given range is " + sum);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 3, 4, 5 };
		int lef = 1;
		int righ = 3;
		RangeQueryBasicPrefix rqbp = new RangeQueryBasicPrefix();
		rqbp.usingPrefixSum(ar, lef, righ);

	}

	// FINAL IMPROVED CODE
	/*
	 * package com.dsa.prefixsum;
	 * 
	 * public class RangeQueryBasicPrefix {
	 * 
	 * public int[] buildPrefix(int[] ar) { if (ar == null || ar.length == 0) {
	 * throw new IllegalArgumentException("Array is empty"); }
	 * 
	 * int[] prefix = new int[ar.length]; prefix[0] = ar[0];
	 * 
	 * for (int i = 1; i < ar.length; i++) { prefix[i] = prefix[i - 1] + ar[i]; }
	 * 
	 * return prefix; }
	 * 
	 * public int rangeSum(int[] prefix, int left, int right) { if (left < 0 ||
	 * right >= prefix.length || left > right) { throw new
	 * IllegalArgumentException("Invalid Range"); }
	 * 
	 * if (left == 0) return prefix[right];
	 * 
	 * return prefix[right] - prefix[left - 1]; }
	 * 
	 * public static void main(String[] args) { int[] ar = {1, 2, 3, 4, 5};
	 * 
	 * RangeQueryBasicPrefix obj = new RangeQueryBasicPrefix();
	 * 
	 * int[] prefix = obj.buildPrefix(ar);
	 * 
	 * System.out.println(obj.rangeSum(prefix, 1, 3)); // 9
	 * System.out.println(obj.rangeSum(prefix, 0, 2)); // 6 } }
	 */

}
