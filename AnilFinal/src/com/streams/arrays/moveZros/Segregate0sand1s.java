package com.streams.arrays.moveZros;

public class Segregate0sand1s {

	public void usingTwoPointer(int[] num) {
		int left = 0;
		int right = num.length - 1;
		while (left < right) {
			if (num[left] == 0) {
				left++;
			} else if (num[right] == 1) {
				right--;
			} else {
				int temp = num[left];
				num[left] = num[right];
				num[right] = temp;
				left++;
				right--;
			}
		}
		for (int a : num) {
			System.out.print(" " + a);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 0, 1, 1, 0, 1, 0, 0, 1 };
		Segregate0sand1s s01 = new Segregate0sand1s();
		s01.usingTwoPointer(ar);

	}

}
