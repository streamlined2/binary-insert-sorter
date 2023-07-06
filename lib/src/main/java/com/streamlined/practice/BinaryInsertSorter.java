package com.streamlined.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BinaryInsertSorter<T> implements Sorter<T> {

	private final Comparator<T> comparator;
	private final T[] array;

	public BinaryInsertSorter(Comparator<T> comparator, @SuppressWarnings("unchecked") T... array) {
		this.comparator = comparator;
		this.array = array;
	}

	@Override
	public List<T> getSorted() {
		for (int index = array.length - 1; index >= 0; index--) {
			moveElementToSortedArea(index);
		}
		return Arrays.asList(array);
	}

	private void moveElementToSortedArea(int elementIndex) {
		final T element = array[elementIndex];
		final int searchIndex = Arrays.binarySearch(array, elementIndex + 1, array.length, element, comparator);
		final int insertIndex = (searchIndex >= 0 ? searchIndex : -searchIndex - 1) - 1;
		final int copyCount = insertIndex - elementIndex;
		System.arraycopy(array, elementIndex + 1, array, elementIndex, copyCount);
		array[insertIndex] = element;
	}

	public static void main(String... args) {
		System.out.println(new BinaryInsertSorter<Integer>(Comparator.reverseOrder(), 90, 10, 34, 40, 78, 23, 47, 5,
				100, 38, 67, 89).getSorted().stream().map(Object::toString).collect(Collectors.joining(",")));
	}

}
