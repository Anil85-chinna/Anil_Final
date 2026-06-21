package com.dsa.binarysearch.upperBound;

public class SearchRangeLastPosition {

	public int lastPosition(int[] ar, int target) {

		int start = 0;
		int end = ar.length - 1;

		int lastPosition = -1;

		while (start <= end) {

			int mid = start + (end - start) / 2;

			// target found
			if (ar[mid] == target) {

				lastPosition = mid;

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

		return lastPosition;
	}

	public static void main(String[] args) {

		int[] ar = { 5, 7, 7, 8, 8, 10 };

		SearchRangeLastPosition sr = new SearchRangeLastPosition();

		System.out.println("last position of target = " + sr.lastPosition(ar, 8));
	}
}