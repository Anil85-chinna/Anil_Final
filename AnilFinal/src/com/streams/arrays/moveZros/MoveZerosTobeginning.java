package com.streams.arrays.moveZros;

public class MoveZerosTobeginning {

	public void usingTwoPointerReadWrite(int[] ar) {
		int end = ar.length - 1;
		for (int i = end; i >= 0; i--) {
			if (ar[i] != 0) {
				ar[end] = ar[i];
				end--;
			}
		}
		while (end >= 0) {
			ar[end] = 0;
			end--;
		}
		for (int a : ar) {
			System.out.print(" " + a);
		}
	}

	public void usingTwoPointerSwapping(int[] ar) {
		int end = ar.length - 1;
		int len = ar.length - 1;
		for (int i = end; i >= 0; i--) {
			if (ar[i] != 0) {
				int temp = ar[end];
				ar[end] = ar[i];
				ar[i] = temp;
				end--;
			}
		}
		for (int a : ar) {
			System.out.print(" " + a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 1, 2, 0, 1, 3, 0, 4, 0 };
		MoveZerosTobeginning mztb = new MoveZerosTobeginning();
		// mztb.usingTwoPointerReadWrite(ar);
		mztb.usingTwoPointerSwapping(ar);

	}

}
