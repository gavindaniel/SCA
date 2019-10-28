package model;

import java.util.Arrays;

public class Practitioner {

	public void sort(int[] array) {

		if (array.length < 2)
			return;

		int midPoint = (array.length) / 2;

		int[] leftHalf = new int[midPoint];
		int[] rightHalf = new int[array.length - midPoint];

		for (int i = 0; i < midPoint; i++)
			leftHalf[i] = array[i];

		int index = 0;
		for (int i = midPoint; i < array.length; i++) {
			rightHalf[index] = array[i];
			index++;
		}

//		System.out.println("Mid Point -> " + midPoint);
//		System.out.println("First Half -> " + Arrays.toString(leftHalf));
//		System.out.println("Second Half -> " + Arrays.toString(rightHalf));
//		System.out.println("**********************");

		sort(leftHalf);
		sort(rightHalf);
		merge(leftHalf, rightHalf, array);
	}

	public void merge(int[] leftHalf, int[] rightHalf, int[] originalArray) {

		int leftSize = leftHalf.length;
		int rightSize = rightHalf.length;

		int leftIndex = 0;
		int rightIndex = 0;
		int mergeIndex = 0;

		while (leftIndex < leftSize && rightIndex < rightSize) {
			if (leftHalf[leftIndex] <= rightHalf[rightIndex]) {
				originalArray[mergeIndex] = leftHalf[leftIndex];
				leftIndex++;
				mergeIndex++;
			} else {
				originalArray[mergeIndex] = rightHalf[rightIndex];
				rightIndex++;
				mergeIndex++;
			}
		}
		// add any remaining elements from the left side, if any
		while (leftIndex < leftSize) {
			originalArray[mergeIndex] = leftHalf[leftIndex];
			leftIndex++;
			mergeIndex++;
		}
		// add any remaining elements from the left side, if any
		while (rightIndex < rightSize) {
			originalArray[mergeIndex] = rightHalf[rightIndex];
			rightIndex++;
			mergeIndex++;
		}
	}

}