package fr.istic.prg3;

import java.util.ArrayList;

/**
 * @version 1.0
 *
 */
public class HeapArray extends ArrayList<Integer> implements Heap {
	
	protected ArrayList<Integer> values;
	protected int size;
	
	public HeapArray(ArrayList<Integer> valuesArray) {
		valuesArray.sort(null);
		this.values = valuesArray;
		this.size = valuesArray.size();
	}
	
	
	public void addValue(int newValue) {
		this.values.add(newValue);
		this.values.sort(null);
	}
	
	
	public int getMax() {
		return this.values.get(size-1);
	}
	
	
	public int extractMax() {
		this.values.remove(size-1);
		return this.values.get(size-2);
	}
	
	
	protected void heapifyDown() {
		// TODO
	}
	
	
	public static int[] heapsort(int[] unsortedValues) {
		// TODO
		int[]tab = {};
		return tab;
	}
	
	
	
	protected int indexLeft(int position) {
		return (2*position)+1;
	}
	
	
	protected int indexRight(int position) {
		return (2*position)+2;
	}
	
	
	protected int indexUp(int position) {
		return (position-1)/2;
	}
	
	
	public void siftDown() {
		this.siftDown(0);
	}
	
	
	protected void siftDown(int position) {
		// TODO
	}
	
	
	public void siftUp() {
		this.siftUp(this.size - 1);
	}
	
	
	protected void siftUp(int position) {
		// TODO
	}
	
	
	protected void swap(int index1, int index2) {
		Integer tmp = index1;
		index1 = index2;
		index2 = tmp;
	}
	
	
	protected void swapIfGreaterAndSiftUp(int index1, int index2) {
		// TODO
	}
	
	
	protected void swapIfLowerAndSiftDown(int index1, int index2) {
		// TODO
	}
	
	
	public String toString() {
		// TODO
		return "";
	}
	
	
	public String toString(String offset) {
		// TODO
		return offset;
	}
	
	
	
	

	public static void main(String[] args) {
		ArrayList<Integer> list1 = new ArrayList();
		list1.add(3);
		list1.add(6);
		list1.add(1);
		list1.add(89);
		list1.add(12);
		System.out.println(list1);
		HeapArray heap1 = new HeapArray(list1);
		System.out.println(heap1.values);
		System.out.println(heap1.getMax());
		System.out.println(heap1.extractMax());
	
}
}
