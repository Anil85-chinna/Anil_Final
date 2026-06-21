package com.dsa.binarysearch;

public class SearchInsertPosition {
	public void usingBinarySearch(int[] ar, int target) {
		if (ar == null || ar.length == 0) {
			System.out.println("please enter the proper input array");
			return;
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
				System.out.println("the index of the given target is = " + mid);
				return;
			}
		}
		System.out.println("the next insertioon position of given target is = " + start);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] ar = { 1, 2, 3, 4, 6 };
		int target = 5;
		SearchInsertPosition sip = new SearchInsertPosition();
		sip.usingBinarySearch(ar, target);

	}

}
