package com.dsa.binarysearch.combineLowerUpper;

/*
 * we can also solve one more problem with exact same code but major different is if specil check not need
 * IMPORTANT UNDERSTANDING

In range query:

lowerBound(L)

means:
⭐ where valid range STARTS.

Even if:
⭐ L itself not present,
next greater value may still belong to range.

That is completely valid.
THE PROBLEM IS 
--> 13.	Range Query Problems 
--> •  Frequency of Target in Sorted Array 
 */

public class CountOccurrencesInSortedArray {
	public int countOccurrences(int[] ar, int target) {
		int lowerBoundIndex = lowerBound(ar, target);
		// target not present
		if (lowerBoundIndex == ar.length || ar[lowerBoundIndex] != target) {// in this case like when that lower bound
																			// value not present in given array.. and
																			// that last value of lower bound is not
																			// equal to target in that case that given
																			// target not present in given array so we
																			// are printing 0 value
			return 0;
		}
		int upperBoundIndex = upperBound(ar, target);
		// count formula
		return upperBoundIndex - lowerBoundIndex;
	}

	// lower bound
	private int lowerBound(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int answer = ar.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] >= target) {
				answer = mid;
				// move LEFT
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return answer;
	}

	// upper bound
	private int upperBound(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int answer = ar.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] > target) {
				answer = mid;
				// move LEFT
				end = mid - 1;
			} else {
				// skip smaller/equal values
				start = mid + 1;
			}
		}
		return answer;
	}

	public static void main(String[] args) {
		int[] ar = { 1, 2, 2, 2, 3, 4, 5 };
		int target = 2;
		CountOccurrencesInSortedArray cosa = new CountOccurrencesInSortedArray();
		System.out.println("count of target = " + cosa.countOccurrences(ar, target));
	}
}