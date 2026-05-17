package com.dsa.prefixsum;

public class PivotIndex {

	public int usingPrefix(int[] ar) {
		if (ar == null || ar.length == 0) {
			// throw new IllegalArgumentException("Array is empty");
			return -1;
		}
		int totalSum = 0;
		for (int arEle : ar) {
			totalSum = totalSum + arEle;
		}
		int leftSum = 0;
		for (int i = 0; i < ar.length; i++) {
			if (2 * leftSum + ar[i] == totalSum) {
				System.out.println("the pivot index is =  " + i);
				return i;
			} else {
				leftSum = leftSum + ar[i];
			}
		}
		return -1;
	}

	public int withOutFormula(int[] ar) {
		if (ar == null || ar.length == 0) {
			return -1;
		}
		int rightSum = 0;
		int leftSum = 0;
		for (int nums : ar) {
			rightSum = rightSum + nums;
		}
		for (int i = 0; i < ar.length; i++) {
			rightSum = rightSum - ar[i];
			if (leftSum == rightSum) {
				return i;
			}
			leftSum = leftSum + ar[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 2, -1, 1, 2, 2 };
		PivotIndex pi = new PivotIndex();
		int pivotIndex = pi.usingPrefix(ar);
		System.out.println("The index is = " + pivotIndex);
		System.out.println(pi.withOutFormula(ar));

	}

}
