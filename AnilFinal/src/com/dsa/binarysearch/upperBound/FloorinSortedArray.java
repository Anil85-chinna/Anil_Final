package com.dsa.binarysearch.upperBound;

public class FloorinSortedArray {

	public int usingBinarySearchPattern(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int floor = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] <= target) {
				floor = ar[mid];
				start = mid + 1;
			} else if (ar[mid] > target) {
				end = mid - 1;
			}
		}
		return floor;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = {6, 8, 9 };
		int target = 7;
		FloorinSortedArray fsa = new FloorinSortedArray();
		System.out.println("the floor for given target is  = "+fsa.usingBinarySearchPattern(ar, target));

	}

}
