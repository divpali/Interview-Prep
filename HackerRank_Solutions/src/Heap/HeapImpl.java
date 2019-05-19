package Heap;

import java.util.Arrays;

public class HeapImpl {

	int capacity = 10;
	int size = 0;

	static int[] items = { 10, 15, 20, 13 };

	public int getLeftChildIndex(int parentIndex) {
		return 2 * parentIndex + 1;
	}

	public int getRightChildIndex(int parentIndex) {
		return 2 * parentIndex + 2;
	}

	public int getParentIndex(int childIndex) {
		return (childIndex - 1) / 2;
	}

	public boolean hasLeftChild(int index) {
		return getLeftChildIndex(index) < size;
	}

	public boolean hasRightChild(int index) {
		return getRightChildIndex(index) < size;
	}

	public boolean hasParent(int index) {
		return getParentIndex(index) >= 0;
	}

	public int leftChild(int index) {
		return items[getLeftChildIndex(index)];
	}

	public int rightChild(int index) {
		return items[getRightChildIndex(index)];
	}

	public int parent(int index) {
		return items[getParentIndex(index)];
	}

	public void swap(int index1, int index2) {
		int temp = items[index1];
		items[index1] = items[index2];
		items[index2] = temp;
	}

	public void ensureCapacity() {
		if (size == capacity) {
			int[] new_items = Arrays.copyOf(items, capacity * 2);
			capacity *= 2;
		}
	}

	public int peek() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		return items[0];
	}

	// extract min element and removes from array
	public int poll() {
		if (size == 0) {
			throw new IllegalStateException();
		}
		int item = items[0];
		items[0] = items[size - 1];
		size--;
		heapifyDown();
		return item;
	}

	// creating the heap
	public void add(int num) {
		ensureCapacity();
		items[size] = num;
		size++;
		heapifyUp();
	}

	public void heapifyUp() {
		int index = size - 1;
		while (hasParent(index) & parent(index) > items[index]) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	public void heapifyDown() {
		int index = 0;
		while (hasLeftChild(index)) {
			int smallestChildIndex = getLeftChildIndex(index);
			if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
				smallestChildIndex = getRightChildIndex(index);
			}

			if (items[index] < items[smallestChildIndex]) {
				break;
			} else {
				swap(index, smallestChildIndex);
			}
			index = smallestChildIndex;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeapImpl h = new HeapImpl();
		h.add(8);
		h.poll();
		for (int i = 0; i < items.length; i++) {
			System.out.println(items[i]);
		}

	}

}
