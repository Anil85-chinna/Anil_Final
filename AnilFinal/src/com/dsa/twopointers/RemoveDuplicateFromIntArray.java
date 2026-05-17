package com.dsa.twopointers;

// this below code to remove duplicate int from int array and sorted array.
public class RemoveDuplicateFromIntArray {

	public int usingTwopointer(int[] ar) {
		if (ar.length == 0)
			return 0;
		if (ar.length == 1)
			return 1;
		int start = 0;
		int end = 1;
		while (end < ar.length) {// becox we are taken end as fast pointer so it will reach end of the array
			if (ar[end] != ar[start]) {
				start++;
				ar[start] = ar[end];
				end++;
			} else {
				end++;
			}
		}
		System.out.println(start + 1);
		return start + 1;
	}

	public int usingForLoop(int[] ar) {
		if (ar.length == 0)
			return 0;
		if (ar.length == 1)
			return 1;
		int slow = 0;
		int end = 1;
		for (int start = end; start < ar.length; start++) {
			if (ar[start] != ar[end]) {
				ar[slow] = ar[start + 1];
				slow++;
			} else {
				slow++;
			}
		}
		return slow + 1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] ar = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
		int[] ar1 = { 1, 2 };
		RemoveDuplicateFromIntArray rdfia = new RemoveDuplicateFromIntArray();
		rdfia.usingTwopointer(ar);
		rdfia.usingForLoop(ar1);

	}

}
