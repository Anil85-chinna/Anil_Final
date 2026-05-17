package com.dsa.twopointers;

public class ContainerWithWater {
	public void usingTwoPointer(int[] ar) {
		int start = 0;
		int end = ar.length - 1;
		int maxWaterValue = Integer.MIN_VALUE;
		while (start < end) {
			int minhight = Math.min(ar[start], ar[end]);
			int waterArea = minhight * (end - start);
			maxWaterValue = Math.max(maxWaterValue, waterArea);
			if (ar[start] < ar[end]) {
				start++;
			} else {
				end--;
			}
		}
		System.out.println("the max water area contained is = " + maxWaterValue);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		ContainerWithWater cww = new ContainerWithWater();
		cww.usingTwoPointer(height);

	}

}
