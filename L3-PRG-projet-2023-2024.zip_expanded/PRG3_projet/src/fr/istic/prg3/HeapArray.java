package fr.istic.prg3;

import java.util.ArrayList;
import java.util.Objects;

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
		this.size++;
	}
	
	
	public int getMax() {
		return this.values.get(size-1);
	}
	
	
	public int extractMax() {
		this.values.remove(size-1);	//val max = dernier val du tableau car tri croissant
		this.size--;
		return this.values.get(size-2);
	}
	
	
	protected void heapifyDown() {
		// TODO
	}
	
	
	public static ArrayList<Integer> heapsort(ArrayList<Integer> unsortedValues) {
		ArrayList<Integer> newList = new ArrayList<Integer>(unsortedValues);
		newList.sort(null);
		return newList;
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
		
	}
	
	
	public void siftUp() {
		this.siftUp(this.size - 1);
	}
	
	
	protected void siftUp(int position) {
		if(position >= 0 && position < this.size) {	//on verifie que position est dans une intervalle correcte
		int parent = indexUp(position);
		while(this.values.get(position) > parent) {	//tant que le fils a une val sup de son parent
			int tmp = this.values.get(position);
			this.values.set(position, this.values.get(parent));
			this.values.set(parent, tmp);		//on échange les valeurs entre fils et parents
			parent = indexUp(position);			// et on reaffecte le parent pour permutation successive doudou je t'aime
		}
		}
	}
	
	
	protected void swap(int index1, int index2) {
		if(index1 >= 0 && index1 < this.size && index2 >= 0 && index2 < this.size ) { // on verifie que lintervalle est correcte
			Integer tmp = this.values.get(index1);
			this.values.set(index1, this.values.get(index2));
			this.values.set(index2,tmp); 
		}
	}
	
	
	protected void swapIfGreaterAndSiftUp(int index1, int index2) {
		// TODO
	}
	
	
	protected void swapIfLowerAndSiftDown(int index1, int index2) {
		// TODO
	}
	
	
	public String toString() {
		return this.toString("");
	}
	
	
	public String toString(String offset) {
		return "";
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

		heap1.swap(0, 3);
		System.out.println(heap1.values);
		heap1.siftUp();
}
}
