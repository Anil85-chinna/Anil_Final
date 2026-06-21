package com.dsa.binarysearch.lowerBoundBinary;

/*
 * same code for other proble also
 * 1.	Minimum Index Satisfying Condition  for this also we can use exactly same code
 */
/* 
 * we can also solve this problem using lower bound exact code problem
 * 8.	First Greater or Equal Element 
 */
/*
 * we can solve this problem also using lower bound exact code
 * 8.	Minimum Index Satisfying Condition 
 */
public class SearchInsertPosition {

	public int usingBinarySearch(int target) {
		int[] ar = { 1, 3, 5, 6 };
		int start = 0;
		int end = ar.length - 1;
		int insertPosition = ar.length;
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (ar[mid] >= target) {
				insertPosition = mid;
				end = mid - 1;
			} else if (ar[mid] < target) {
				start = mid + 1;
			}
		}
		return insertPosition;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInsertPosition sip = new SearchInsertPosition();
		System.out.println("using binary lower bound = " + sip.usingBinarySearch(2));

	}

}
