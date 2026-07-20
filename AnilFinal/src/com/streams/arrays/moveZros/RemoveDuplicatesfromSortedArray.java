package com.streams.arrays.moveZros;

//For sortedArray
public class RemoveDuplicatesfromSortedArray {
	public void usingTwoPointer(int[] nums) {
		int left = 0;
		int right = 0;
		int length = nums.length - 1;
		for (right = 0; right < length; right++) {
			if (nums[right] != nums[right + 1]) {
				nums[left] = nums[right];
				left++;
			}
		}
		// Handle the last element
		nums[left] = nums[length];
		left++;
		for (int i = 0; i < left; i++) {
			System.out.print(" " + nums[i]);
		}
		System.out.println("\n new length  = " + left);

	}

	/*
	 * We are saying:
	 * 
	 * "I already know that index 0 is unique."
	 * 
	 * That's our starting point.
	 * 
	 * Now start reading
	 * 
	 * Notice something important.
	 * 
	 * We do not start reading from index 0.
	 * 
	 * We start from
	 * 
	 * read = 1;
	 * 
	 * Why?
	 * 
	 * Because index 0 is already accepted. i need to start writ with 0 bcoz we are
	 * assuming that starting value is UNIQUE value. SO we need to check that with
	 * previous that 0 value
	 */
	/*
	 * This is the standard interview solution. You derived it yourself instead
	 */
	// INTERVIEW PREFERED BECOZ PREVIOUS PROBLEMS WE SOLVED USING THIS ONLY RYT?
	public void usingTwoPointerReadWrite(int[] num) {
		int write = 0;
		int read = 1;
		int len = num.length - 1;
		for (read = 1; read <= len; read++) {
			if (num[read] != num[write]) {
				write++;// bcoz we are assuming num[0] is uniquew values that why i am incrementing that
						// value first and next assigning new value. if i didnt do that it will modify
						// the starting unique valu
				num[write] = num[read];
			}
		}
		for (int i = 0; i <= write; i++) {
			System.out.print(" " + num[i]);
		}
		System.out.println(" \n the length is = ");
		System.out.println(write + 1);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 0, 0, 1, 1, 2, 2, 3, 3, 4 };
		RemoveDuplicatesfromSortedArray rdfsa = new RemoveDuplicatesfromSortedArray();
		// rdfsa.usingTwoPointer(ar);
		rdfsa.usingTwoPointerReadWrite(ar);

	}

}
