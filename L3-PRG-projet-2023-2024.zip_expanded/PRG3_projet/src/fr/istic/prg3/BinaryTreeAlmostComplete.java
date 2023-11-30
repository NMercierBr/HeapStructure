/**
 * 
 */
package fr.istic.prg3;

import java.util.Objects;



/**
 * @version 1.0
 *
 */
public class BinaryTreeAlmostComplete {
	
	protected int rootValue;
	protected BinaryTreeAlmostComplete left;
	protected BinaryTreeAlmostComplete right;
	protected BinaryTreeAlmostComplete up;
	protected int nbDescendants;
	
	
	public BinaryTreeAlmostComplete(int value) {
		this(value, null);
	}
	
	
	public BinaryTreeAlmostComplete(int[] values) {
		if(values.length != 0) {
			rootValue = values[0];
			if(values.length > 1) {
				for(int i = 1 ; i < values.length ; i++) {
					this.addValue(values[i]);
				}
			}
		}
	}
	
	
	public BinaryTreeAlmostComplete(int value, BinaryTreeAlmostComplete parent) {
		this.rootValue = value;
		this.left = null;
		this.right = null;
		this.up = parent;
		this.updateNumberOfDescendants();
	}
		
	
	public void addValue(int value) {
		if (Objects.isNull(this.left)) {
			this.left = new BinaryTreeAlmostComplete(value, this);
			this.updateNumberOfDescendants();
		}
		else {
			if (Objects.isNull(this.right)) {
				this.right = new BinaryTreeAlmostComplete(value, this);
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
		}
	}
	
	
	
	protected static int getLevels(int n) {
		return (int)(Math.log(n + 1) / Math.log(2));
	}
	
	
	protected BinaryTreeAlmostComplete getRightmostLowestNode() {
			if(Objects.isNull(this.left)){
				return this;
			} else {
				int leftDesc = this.left.nbDescendants;
				if(getLevels(leftDesc) == getLevels(leftDesc+1)) {
					return this.left.getRightmostLowestNode();
				} else {
					if(Objects.nonNull(this.right)) {
						int rightDesc = this.right.nbDescendants;
						if(getLevels(leftDesc) > getLevels(rightDesc)) {
							return this.left.getRightmostLowestNode();
						} else {
						return this.right.getRightmostLowestNode();
						}
					} else {
						return this.left.getRightmostLowestNode();
					}
				}
			}
	}
	
	
	public void siftDown() {
		BinaryTreeAlmostComplete node = this;
		int currentval = node.rootValue;
		if(Objects.isNull(node.left)) {	//sous arbre gauche vide, current est une feuille
			return;
		} else {
			int leftVal = node.left.rootValue;
			if(Objects.nonNull(node.right)) { // current a deux fils
				boolean leftSupRight = (node.left.rootValue > node.right.rootValue);
				
				if(currentval < leftVal && leftSupRight) {//echange de current a left
					int tmp = currentval;
					currentval = leftVal;
					leftVal = tmp;
					node.left.siftDown();
				} else if(currentval < node.right.rootValue) {	//echange de current a right
					int tmp = node.rootValue;
					node.rootValue = node.right.rootValue;
					node.right.rootValue = tmp;
					node.right.siftDown();
				}
			} else {
				if(currentval < leftVal) {	//echange de current a left
					int tmp = node.rootValue;
					node.rootValue = leftVal;
					leftVal = tmp;
					node.left.siftDown();
				} else {
					return;
				}
			}
		}
	}
	
	public void siftUp() {
		BinaryTreeAlmostComplete node = this.getRightmostLowestNode();
		while(Objects.nonNull(node.up) && node.up.rootValue < node.rootValue) {
			int tmp = node.rootValue;
			node.rootValue = node.up.rootValue;
			node.up.rootValue = tmp;
			node = node.up;
		}
	}
	
	
	
	public String toString() {
		return this.toString("");
	}
	
	
	public String toString(String offset) {
		String res = offset;
		res += rootValue + " (" + nbDescendants + " descendants)\n";
		if(Objects.nonNull(left)) {
			res+= left.toString("  |" + offset);
		}
		if(Objects.nonNull(right)) {
			res+= right.toString("  |" + offset);
		}
		return res;
	}
	
	
	
	protected void updateNumberOfDescendants() {
		this.nbDescendants = 0;
		if (Objects.nonNull(this.left)) {
			this.nbDescendants += 1 + this.left.nbDescendants;
		}
		if (Objects.nonNull(this.right)) {
			this.nbDescendants += 1 + this.right.nbDescendants;
		}
		if (Objects.nonNull(this.up)) {
			up.updateNumberOfDescendants();
		}
	}
	

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arbr = { 1 , 2 ,3, 4};
		
		BinaryTreeAlmostComplete tree1 = new BinaryTreeAlmostComplete(arbr);
		int[] treeValues = {109, 107, 111, 112, 103, 104, 110, 101, 106, 102, 108, 105};
		BinaryTreeAlmostComplete heap2 = new BinaryTreeAlmostComplete(treeValues);
		System.out.println(tree1.getRightmostLowestNode());
		System.out.println(heap2);
		System.out.println(heap2.getRightmostLowestNode());
		System.out.println();
		//heap2.siftUp();
		
		//System.out.println(heap2);
		heap2.siftDown();
		System.out.println(heap2);
		
	}

}
