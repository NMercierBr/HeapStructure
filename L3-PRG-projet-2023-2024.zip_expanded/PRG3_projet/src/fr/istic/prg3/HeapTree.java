/**
 * 
 */
package fr.istic.prg3;

import java.util.Objects;



/**
 * @version 1.0
 *
 */
public class HeapTree extends BinaryTreeAlmostComplete implements Heap {
	
	public HeapTree(int value) {
		super(value,null);
	}
	
	
	public HeapTree(int value, HeapTree parent) {
		super(value,parent);
	}
	
	
	public HeapTree(int[] tab) {
		super(tab);
	}
	
	
	public void addValue(int value) {
		if (Objects.isNull(this.left)) {
			this.left = new HeapTree(value, this);
			this.updateNumberOfDescendants();
		}
		else {
			if (Objects.isNull(this.right)) {
				this.right = new HeapTree(value, this);
				this.updateNumberOfDescendants();
			}
			else {
				// both left and right exist
				int nbDescLeft = this.left.nbDescendants;
				if (getLevels(nbDescLeft) == getLevels(nbDescLeft + 1)) {
					// the lowest level of left child is not full
					this.left.addValue(value);
				}
				else {
					// the lowest level of left child is full
					int nbDescRight = this.right.nbDescendants;
					if (nbDescLeft > nbDescRight) {
						// the lowest level of left child is full, AND the lowest level of right child is not full
						this.right.addValue(value);
					}
					else {
						// both left and right child are full and have the same level
						this.left.addValue(value);
					}
				}
			}
		} this.getRightmostLowestNode().siftUp();
	}
	
	
	public int extractMax() {
		int tmp = this.rootValue;
		HeapTree lowest = (HeapTree) this.getRightmostLowestNode();
		this.rootValue = lowest.rootValue;
		lowest.rootValue = tmp;
		
		if(Objects.nonNull(lowest.up)) {
			if(Objects.nonNull(lowest.right)) {
				lowest.up.right = null;
			}else {
				lowest.up.left=null;
			}
			this.updateNumberOfDescendants();
		} 
		this.siftDown();
		return getMax();
	}
	
	
	public int getMax() {
		return this.rootValue;
	}
	
	
	public static int[] heapsort(int[] unsortedValues) {
		// TODO
	}
	
	
	
	
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CONSTRUCTION");
		int[] treeValues = {109, 107, 111, 112, 103, 104, 110, 101, 106, 102, 108, 105};
		HeapTree myTree = new HeapTree(treeValues);
		System.out.println(myTree);
		System.out.println("\n");
		//System.out.println(myTree.getMax());
		System.out.println(myTree.extractMax());
		System.out.println(myTree);
		
	}

}
