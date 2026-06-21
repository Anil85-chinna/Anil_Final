package com.dsa.binarysearch;

public class ValidPerfectSquare {
	public boolean usingBinarySearch(int num) {
		int start = 1;
		int end = num;
		int mid = 0;
		if (num == 0 || num == 1) {
			return true;
		}
		while (start <= end) {
			mid = start + (end - start) / 2;
			// Can overflow for large numbers.
			long perfectSquerValue = (long) mid * mid;
			if (perfectSquerValue < num) {
				start = mid + 1;
			} else if (perfectSquerValue > num) {
				end = mid - 1;
			} else {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidPerfectSquare vps = new ValidPerfectSquare();
		if (vps.usingBinarySearch(101)) {
			System.out.println("the perfect square we got");
		} else {
			System.out.println("we didnt get perfect square ");
		}

	}

}
