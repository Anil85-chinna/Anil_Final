package com.streams.arrays.moveZros;

public class RemoveElements {
	public void usingTwoPointer(int[] nums, int val) {
		int write = 0;
		int arLength = nums.length - 1;
		for (int read = 0; read <= arLength; read++) {
			if (nums[read] != val) {
				nums[write] = nums[read];
				write++;
			}
		}
		for (int i = 0; i <= write; i++) {
			System.out.print(" " + nums[i]);
		}
		System.out.println("the length is  " + write);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 0, 1, 2, 2, 3, 0, 4, 2 };
		int val = 2;
		RemoveElements me = new RemoveElements();
		me.usingTwoPointer(nums, val);

	}

}
