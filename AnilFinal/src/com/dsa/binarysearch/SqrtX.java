package com.dsa.binarysearch;

public class SqrtX {

	public int usingBinarySearch(int num) {
		if (num == 0 || num == 1) {
			return num;
		}
		int start = 1;
		int end = num;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			long squareRoot = (long) mid * mid;
			if (squareRoot > num) {
				end = mid - 1;
			} else if (squareRoot < num) {
				start = mid + 1;
			} else {
				return mid;
			}
		}
		return end;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sqr = 66;
		SqrtX sqx = new SqrtX();
		System.out.println("the square root of given number is = " + sqx.usingBinarySearch(sqr));

	}

}
