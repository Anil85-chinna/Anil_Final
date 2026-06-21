package com.dsa.binarysearch.upperBound;

public class LastOccurrenceofElementinSortedArray {

	public int usingBinarySearch(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int lastOccurrence = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			// target found
			if (ar[mid] == target) {
				lastOccurrence = mid;
				// move RIGHT to find later occurrence
				start = mid + 1;
			}
			// need bigger values
			else if (ar[mid] < target) {
				start = mid + 1;
			}
			// move LEFT
			else {
				end = mid - 1;
			}
		}
		return lastOccurrence;// here i can use the same logic and exact code of upper bound logic at end we
								// need minus 1 from that values that it
	}

	public static void main(String[] args) {
		int[] arr = { 1, 2, 4, 4, 4, 4, 4, 5, 6 };
		int target = 4;
		LastOccurrenceofElementinSortedArray loesa = new LastOccurrenceofElementinSortedArray();
		System.out.println("the index of last occurrence is = " + loesa.usingBinarySearch(arr, target));
	}
}