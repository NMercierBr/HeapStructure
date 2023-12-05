package fr.istic.prg3.test;

import static org.junit.Assert.assertTrue;
import org.junit.Test;
import fr.istic.prg3.BinaryTreeAlmostComplete;

public class TestBinaryTreeAlmostComplete {

	int[] treeValues = {109, 107, 111, 112, 103, 104, 110, 101, 106, 102, 108, 105};
	BinaryTreeAlmostComplete heap2 = new BinaryTreeAlmostComplete(treeValues);
	
	@Test
	public void testGetRightmostLowest() {
		BinaryTreeAlmostComplete rightLowest = heap2.getRightmostLowestNode();
		assertTrue(rightLowest.getRootValue() == 105);
	}
	
	@Test
	public void testGetRightmostLowestAndSiftUp() {
		BinaryTreeAlmostComplete rightLowest = heap2.getRightmostLowestNode();
		heap2.siftUp();
		assertTrue(rightLowest.getRootValue() == 104);
	}
	
	@Test
	public void testSiftDown() {
		heap2.siftDown();
		assertTrue(heap2.getRootValue() == 111);
	}
	
	
}
