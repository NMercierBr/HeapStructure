package fr.istic.prg3;

/**
 * @version 1.0
 *
 */
public class HeapArray implements Heap {
	
	protected int[] values;
	protected int size;
	
	public HeapArray(int[] valuesArray) {
		// TODO
	}
	
	
	public void addValue(int newValue) {
		// TODO
	}
	
	
	public int getMax() {
		// TODO
		return 0;
	}
	
	
	public int extractMax() {
		// TODO
		return 0;
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
		// TODO
		return 0;
	}
	
	
	protected int indexRight(int position) {
		// TODO
		return 0;
	}
	
	
	protected int indexUp(int position) {
		// TODO
		return 0;
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
		// TODO
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
		// TODO
	
}
}