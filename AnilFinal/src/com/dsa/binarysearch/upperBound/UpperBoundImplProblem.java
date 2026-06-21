package com.dsa.binarysearch.upperBound;

/*
 * below problem code i can use for this problem also
 * First Strictly Greater Element

Algorithms

Problem Statement

Given:
⭐ a sorted array of integers
⭐ and a target value x

Find:
⭐ the FIRST element in the array that is strictly greater than x.

If no such element exists:
return:

-1
 */
/*
 * we can also solve one more problem with same exact code
 * Insert Position After Duplicates

Algorithms

Given a sorted array containing duplicate elements and a target value, find the index where the target should be inserted AFTER all existing duplicates.
You must solve the problem using O(log n) binary search.
 */
/*
 * we can also solve this problem using upperboundimpl
 * 8.	First Strictly Greater Element but difference is we need value here not index..
 */
/*
 * we can also dolve below problem
 * Insert Position After Duplicates
 */
public class UpperBoundImplProblem {

	public int usingBinarySearch(int target) {
		int[] ar = { 1, 1, 1, 1 };
		int start = 0;
		int end = ar.length - 1;
		int result = ar.length; // here we nees to give -1 value
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] > target) {
				result = mid;
				end = mid - 1;
			} else if (ar[mid] < target) {
				start = mid + 1;
			} else {
				start = mid + 1;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UpperBoundImplProblem ubp = new UpperBoundImplProblem();
		System.out.println(ubp.usingBinarySearch(1));

	}

}
