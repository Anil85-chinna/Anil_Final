package com.dsa.binarysearch.combineLowerUpper;

/*
 * we can also solve below this problem using exact code of this problem
 * Equal Range Problem
 */
/*
 * we can also solve this proble using this exact code
 * 13.	Duplicate Segment Length Problems
 * --> •  Search Range Complete Problem  
 */
public class FindFirstAndLastOccurencrOfTareget {

	public int[] usingBinarySearch(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int[] result = { -1, -1 };
		while (start <= end) {// we can also use this way to find first occuenrcr
			int mid = start + (end - start) / 2;
			if (ar[mid] >= target) {
				if (ar[mid] == target) {
					result[0] = mid;
				}
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		System.out.println("the first occurance = " + result[0]);
		int start1 = 0;
		int end1 = ar.length - 1;
		while (start1 <= end1) {
			int mid = start1 + (end1 - start1) / 2;
			if (ar[mid] == target) {
				result[1] = mid;
				start1 = mid + 1;
			} else if (ar[mid] < target) {
				start1 = mid + 1;
			} else {
				end1 = mid - 1;
			}
		}
		System.out.println("the last occuencer = " + result[1]);
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindFirstAndLastOccurencrOfTareget fflot = new FindFirstAndLastOccurencrOfTareget();
		int[] ar = { 1, 2, 3, 5, 5, 5, 5, 8 };
		int target = 5;
		int[] result = fflot.usingBinarySearch(ar, target);
		System.out.println("the start and end index of given target is " + result[0] + " " + result[1]);

	}

}
