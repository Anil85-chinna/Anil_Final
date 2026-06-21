package com.dsa.binarysearch.lowerBoundBinary;

public class FirstOccurrenceOfElementInSortedArray {

	public int usingBinarySearch(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int firstOccurrence = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			// target found
			if (ar[mid] == target) {
				firstOccurrence = mid;
				// move LEFT to find earlier occurrence
				end = mid - 1;
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
		return firstOccurrence;
	}

	public static void main(String[] args) {
		int[] ar = { 1, 3, 5, 5, 5, 6 };
		int target = 5;
		FirstOccurrenceOfElementInSortedArray foesa = new FirstOccurrenceOfElementInSortedArray();
		System.out.println("first occurrence of given element = " + foesa.usingBinarySearch(ar, target));
	}
}