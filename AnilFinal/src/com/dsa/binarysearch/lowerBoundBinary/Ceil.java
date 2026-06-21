package com.dsa.binarysearch.lowerBoundBinary;

/*
 * 1.	First Greater or Equal Element 
 * ceil proble also solve this problem.. 
 * Ceil Meaning
smallest value >= target
First Greater or Equal Element Meaning
first value >= target

Same thing.
 */
public class Ceil {

	public int usingBinarySearch(int target) {
		int[] ar = { 2, 4, 6, 8 };
		int start = 0;
		int end = ar.length - 1;
		int ceil = -1;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] >= target) {
				ceil = ar[mid];
				end = mid - 1;
			} else if (ar[mid] < target) {
				start = mid + 1;
			}
		}
		return ceil;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Ceil cl = new Ceil();
		System.out.println("the ceil of the given array is = " + cl.usingBinarySearch(5));

	}

}
