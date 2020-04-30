public class BinaryTree {
	int val;
	BinaryTree left;
	BinaryTree right;
	
	public BinaryTree(int val) {
		this.val = val;
		this.left = null;
		this.right = null;
	}
	
	public BinaryTree(int val, BinaryTree left, BinaryTree right) {
		this.val = val;
		this.right = right;
		this.left = left;
	}
}