package com.streams.arrays.moveZros;

public class MoveZeros {

	public void usingTwoPointerReadWrite(int[] ar) {
		int arLength = ar.length - 1;
		int start = 0;
		for (int i = 0; i <= arLength; i++) {
			if (ar[i] != 0) {
				ar[start] = ar[i];
				start++;
			}
		}
		while (start <= arLength) {
			ar[start] = 0;
			start++;
		}
		System.out.println("now printing the result");
		for (int a : ar) {
			System.out.print(a + " ");
		}

	}

	public void usingTwopointerSwapping(int[] ar) {
		int left = 0;
		int arLength = ar.length - 1;
		for (int right = 0; right < arLength; right++) {
			if (ar[right] != 0) {
				int temp = ar[left];
				ar[left] = ar[right];
				ar[right] = temp;
				left++;
			}
		}
		for (int a : ar) {
			System.out.print(" " + a);
		}
	}

	public void UsingBruthForchShiftingZeors(int[] ar) {
		int arLength = ar.length - 1;
		for (int i = 0; i < arLength; i++) {
			if (ar[i] == 0) {
				for (int j = i; j < arLength; j++) {
					ar[j] = ar[j + 1];
				}
				ar[arLength] = 0;
				arLength--;
				i--;
			}
		}
		for (int a : ar) {
			System.out.print("\n" + a + " ");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 1, 2, 0, 1, 3, 0, 4, 0 };
		MoveZeros mz = new MoveZeros();
		//mz.usingTwoPointerReadWrite(input);
		// mz.UsingBruthForchShiftingZeors(input);
		mz.usingTwopointerSwapping(input);

	}

}
