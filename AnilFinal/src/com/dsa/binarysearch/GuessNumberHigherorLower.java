package com.dsa.binarysearch;

public class GuessNumberHigherorLower {

	public int guesNumber(int n) {
		int pickedNumber = 6;
		if (pickedNumber == n) {
			return 0;
		} else if (pickedNumber > n) {
			return 1;
		} else {
			return -1;
		}

	}

	public int usingBinarySearch(int n) {
		int start = 1;
		int end = n;
		int mid = 0;
		while (start <= end) {
			mid = start + (end - start) / 2;
			int guessResult = guesNumber(mid);
			if (guessResult == 0) {
				System.out.println("you guessed the exact number");
				return mid;
			} else if (guessResult == 1) {
				start = mid + 1;
				System.out.println("searching in right side ");
			} else {
				end = mid - 1;
				System.out.println("please select the lower number please");
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GuessNumberHigherorLower gnhl = new GuessNumberHigherorLower();
		gnhl.usingBinarySearch(20);

	}

}
