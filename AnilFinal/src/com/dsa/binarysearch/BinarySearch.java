package com.dsa.binarysearch;

/*
 * Given a sorted integer array nums and an integer target, return the index of target.

If target does not exist, return -1.
 */
public class BinarySearch {
	public int usingBinarySearch(int[] ar, int target) {
		if (ar == null || ar.length == 0) {
			return -1;
		}
		int start = 0;
		int end = ar.length - 1;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			if (ar[mid] > target) {
				end = mid - 1;
			} else if (ar[mid] < target) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return -1;
	}

	public int usingRecursion(int[] ar, int target, int start, int end) {
		if (start > end) {
			return -1;
		}
		int mid = start + (end - start) / 2;
		if (ar[mid] == target) {
			return mid;
		} else if (ar[mid] > target) {
			end = mid - 1;
			return usingRecursion(ar, target, start, end);
		} else {
			start = mid + 1;
			return usingRecursion(ar, target, start, end);
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;
		BinarySearch bs = new BinarySearch();
		System.out.println(bs.usingBinarySearch(nums, target));

	}

}
