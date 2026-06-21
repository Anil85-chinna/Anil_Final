package com.dsa.binarysearch.combineLowerUpper;

public class CountSmallerGreaterElements {

	public void countOfSmallerBiggerEle(int[] ar, int target) {
		int lowerBoundIndex = findLowerBoundValue(ar, target);
		System.out.println("the count of smaller element of given target is = " + lowerBoundIndex);
		int upperBoundIndex = findUpperBoundValue(ar, target);
		int biggerCount = ar.length - upperBoundIndex;
		System.out.println("the count of bigger element after target is = " + biggerCount);
	}

	public int findLowerBoundValue(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int lowerBoundIndex = ar.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] >= target) {
				lowerBoundIndex = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return lowerBoundIndex;
	}

	public int findUpperBoundValue(int[] ar, int target) {
		int start = 0;
		int end = ar.length - 1;
		int upperBoundIndex = ar.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] > target) {
				upperBoundIndex = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return upperBoundIndex;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 2, 2, 3, 4, 5 };
		int target = 2;
		CountSmallerGreaterElements csge = new CountSmallerGreaterElements();
		csge.countOfSmallerBiggerEle(ar, target);

	}

}
