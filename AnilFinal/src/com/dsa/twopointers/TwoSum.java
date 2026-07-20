package com.dsa.twopointers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {

	public void twoSumUsingTwoPointerForValues(int[] numbers, int target) {
		int start = 0, end = numbers.length - 1;
		while (start < end) {
			int sum = numbers[start] + numbers[end];
			if (sum == target) {
				System.out.println("the numbers are = " + numbers[start] + "," + numbers[end]);
				start++;
				end--;
			} else if (sum < target) {
				start++;
			} else if (sum > target) {
				end--;
			}
		}
	}

	public void twoSumUsingTwoPointerForIndexes(int[] nums, int target) {
		int start = 0, end = nums.length - 1;
		while (start < end) {
			int sum = nums[start] + nums[end];
			if (sum == target) {
				System.out.println("the indexes are = " + start + "," + end);
				start++;
				end--;
			} else if (sum < target) {
				start++;
			} else {
				end--;
			}

		}
	}

	public void twoSumUsingHashMap(int[] nums, int target) {
		Map<Integer, Integer> twoSumMap = new HashMap<>();
		int remainder = 0;
		for (int i = 0; i < nums.length; i++) {
			remainder = target - nums[i];
			if (twoSumMap.containsKey(remainder)) {
				System.out.println("now printing the values = " + nums[i] + "," + remainder);
				System.out.println("now i am printing the index = " + twoSumMap.get(remainder) + "," + i);
			} else {
				twoSumMap.put(nums[i], i);
			}
		}

	}

	public void threeSumUsingTwoPointers(int[] nums, int target) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			int complement = target - nums[i];
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				int sum = nums[start] + nums[end];
				if (sum == complement) {
					System.out.println("the 3 sum values are = " + nums[i] + "," + nums[start] + "," + nums[end]);
					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}
					start++;
					end--;
				} else if (sum < complement) {
					start++;
				} else {
					end--;
				}
			}

		}

	}

	/*
	 * Write a program to print combinations that sum to 6 Input: nums = [2, 4, 3,3,
	 * 5, 7] target = 6 Output: [[2,4], [3,3]]
	 */
	public void usingBruthForce(int[] nums, int givenNum) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (givenNum == nums[i] + nums[j]) {
					System.out.println(nums[i] + " " + nums[j]);
				}
			}
		}
	}

	public void usinghasSet(int[] nums, int target) {
		Set<Integer> inputSet = new HashSet<>();
		int start = 0;
		int end = nums.length - 1;
		for (int i = 0; i < end; i++) {
			int remainder = target - nums[i];
			if (inputSet.contains(remainder)) {
				System.out.println("the values are = " + remainder+","+ nums[i] );
			} else {
				inputSet.add(nums[i]);
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = { 2, 7, 7, 15 };
		int target = 9;
		int[] threeSum = { -1, 0, 1, 2, -1, -4 };
		int threeTarget = 0;
		int[] num = { 2, 4, 3, 3, 5, 7 };
		TwoSum ts = new TwoSum();
		ts.twoSumUsingTwoPointerForValues(nums, target);
		ts.twoSumUsingTwoPointerForIndexes(nums, target);
		ts.twoSumUsingHashMap(nums, target);
		ts.threeSumUsingTwoPointers(threeSum, threeTarget);
		ts.usingBruthForce(num, 6);
		ts.usinghasSet(num, 6);

	}

}
