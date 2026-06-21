package com.dsa.binarysearch.onAnswer;

public class KokoEatingBananas {

	public int usingBinarySeacrOnAnswers(int[] piles, int targetHour) {
		int start = 1;
		int end = Integer.MAX_VALUE;
		int possibleMinHours = 0;
		// find maximum pile
		for (int pile : piles) {
			end = Math.max(end, pile);
		}
		while (start <= end) {
			int mid = start + (end - start) / 2;
			if (canPossible(piles, targetHour, mid)) {
				possibleMinHours = mid;
				// try smaller speed
				end = mid - 1;
			} else {
				// need bigger speed
				start = mid + 1;
			}
		}
		return possibleMinHours;
	}

	public boolean canPossible(int[] piles, int targetHour, int mid) {
		int actualHours = 0;
		for (int i = 0; i <= piles.length - 1; i++) {
			actualHours = actualHours + (piles[i] + mid - 1) / mid;
		}
		if (actualHours <= targetHour) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] piles = { 3, 6, 7, 11 };
		int h = 8;
		KokoEatingBananas kkeb = new KokoEatingBananas();
		System.out.println("the minimum hours taken by koko to eat banana is calculated = "
				+ kkeb.usingBinarySeacrOnAnswers(piles, h));

	}

}
