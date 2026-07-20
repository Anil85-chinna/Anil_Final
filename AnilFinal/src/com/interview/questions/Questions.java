package com.interview.questions;

public class Questions {

	public void rerrangeNumbers(int[] ar) {
		int evenIndex = 0;
		int oddIndex = 1;
		int[] resultArray = new int[ar.length];
		for (int i = 0; i < ar.length; i++) {
			if (ar[i] == 1) {
				resultArray[evenIndex] = ar[i];
				evenIndex = evenIndex + 2;
			} else {
				resultArray[oddIndex] = ar[i];
				oddIndex = oddIndex + 2;
			}
		}
		for (int num1 : resultArray) {
			System.out.println(num1);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 1, 1, 0, 0, 0 };
		Questions q = new Questions();
		q.rerrangeNumbers(ar);

	}

}
