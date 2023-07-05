package com.streamlined.practice;

import java.util.Comparator;
import java.util.List;

public class BinaryInsertSorter<T> implements Sorter<T> {

	private final Comparator<T> comparator;
	private final T[] array;

	public BinaryInsertSorter(Comparator<T> comparator, T... array) {
		this.comparator = comparator;
		this.array = array;
	}

	@Override
	public List<T> getSorted() {
		// TODO Auto-generated method stub
		return null;
	}

}
