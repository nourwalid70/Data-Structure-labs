package project2;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;


class tester {

	@Test
	void test() {
		MiscUtils b = new MiscUtils();
		BinaryTreeNode root = b.insert(null, 20);
		b.insert(root, 30);
		b.insert(root, 10);
		b.insert(root, 35);
		b.insert(root, 25);
		b.insert(root, 15);
		b.insert(root, 10);
		List<Integer> l = new ArrayList<Integer>();
		l.add(20);
		l.add(10);
		l.add(15);
		l.add(30);
		l.add(25);
		l.add(35);
		b.get(root);
		assertEquals(b.L,l);
		assertTrue(b.isValidBST(root));
		assertTrue(b.isValidBST(null));
		assertTrue(b.isValidBST(new BinaryTreeNode(10)));
	}
	
	@Test
	void test2() {
		MiscUtils b = new MiscUtils();
		BinaryTreeNode root = new BinaryTreeNode(20);
		BinaryTreeNode l1 = new BinaryTreeNode(20);
		BinaryTreeNode r1 = new BinaryTreeNode(30);
		BinaryTreeNode l2 = new BinaryTreeNode(40);
		BinaryTreeNode r2 = new BinaryTreeNode(15);
		root.left=l1;
		root.right=r1;
		r1.left =l2;
		r1.right = r2;
		assertFalse(b.isValidBST(root));
		
		 root = new BinaryTreeNode(20);
		 l1 = new BinaryTreeNode(10);
		 r1 = new BinaryTreeNode(30);
		 l2 = new BinaryTreeNode(20);
		 r2 = new BinaryTreeNode(40);
		root.left=l1;
		root.right=r1;
		r1.left =l2;
		r1.right = r2;
		assertFalse(b.isValidBST(root));
		
		root = new BinaryTreeNode(25);
		 l1 = new BinaryTreeNode(15);
		 r1 = new BinaryTreeNode(30);
		 l2 = new BinaryTreeNode(24);
		 r2 = new BinaryTreeNode(40);
		root.left=l1;
		root.right=r1;
		r1.left =l2;
		r1.right = r2;
		assertFalse(b.isValidBST(root));
		
		
	}
	@Test
	void test3() {
		//[10,5,15,3,7,null,18], L = 7, R = 15
	MiscUtils b = new MiscUtils();
	BinaryTreeNode root1 = b.insert(null, 10);
	b.insert(root1, 5);
	b.insert(root1, 15);
	b.insert(root1, 3);
	b.insert(root1, 7);
	b.insert(root1, 16);
	b.insert(root1, 18);
	assertEquals(b.sumRange(root1, 7, 15),32);
	
	//root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
	BinaryTreeNode root2 = b.insert(null, 10);
	b.insert(root2, 5);
	b.insert(root2, 15);
	b.insert(root2, 3);
	b.insert(root2, 7);
	b.insert(root2, 13);
	b.insert(root2, 18);
	b.insert(root2, 1);
	b.insert(root2, 6);
	assertEquals(b.sumRange(root2, 6, 10),23);
	}
}
