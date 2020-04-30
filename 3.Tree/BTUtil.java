public class BTUtil {
	
	public void preorder(BinaryTree bt) {
		if (bt != null) {
			System.out.print(bt.val + " ");
			preorder(bt.left);
			preorder(bt.right);
		}
 	}
	
	public void inorder(BinaryTree bt) {
		if (bt != null) {
			inorder(bt.left);
			System.out.print(bt.val + " ");
			inorder(bt.right);
		}
 	}
	
	public void postorder(BinaryTree bt) {
		if (bt != null) {
			postorder(bt.left);
			postorder(bt.right);
			System.out.print(bt.val + " ");
		}
 	}
	
	public boolean equal(BinaryTree bt1, BinaryTree bt2) {
		boolean flag = false;
		if (bt1 == null && bt2 == null) return true;
		if (bt1 != null && bt2 != null) {
			if (bt1.val == bt2.val) 
				if (equal(bt1.left,bt2.left))
					flag = equal(bt1.right,bt2.right);
			return flag;
		} else {
			return false;
		}
	}
	
	public int count(BinaryTree bt) {
		if (bt == null) return 0;
		else {
			int left = count(bt.left);
			int right = count(bt.right);
			return left + right + 1;
		}
	}
	
	public int height(BinaryTree bt) {
		if (bt == null) return 0;
		else {
			int left = height(bt.left);
			int right = height(bt.right);
			return Math.max(left,right) + 1;
		}
	}
	
	public void swap(BinaryTree bt) {
		if (bt != null) {
			swap(bt.left);
			swap(bt.right);
			BinaryTree temp = bt.left;
			bt.left = bt.right;
			bt.right = temp;
		}
	}
	
	public int leafNode(BinaryTree bt) {
		if (bt == null) {
			return 0;
		} else {
			int left = leafNode(bt.left);
			int right = leafNode(bt.right);
			if (left + right == 0) return 1;
			else return left + right;
		}
		
	}
	public static void main(String[] args) {
		BinaryTree bt1 = new BinaryTree(8);
		BinaryTree bt2 = new BinaryTree(5);
		BinaryTree bt3 = new BinaryTree(7);
		BinaryTree bt4 = new BinaryTree(2);
		BinaryTree bt5 = new BinaryTree(4);
		BinaryTree bt6 = new BinaryTree(1);
		bt1.left = bt2;
		bt1.right = bt3;
		bt2.left = bt4;
		bt2.right = bt5;
		bt3.left = bt6;
		
		BTUtil util = new BTUtil();
		util.preorder(bt1);
		System.out.println();
		util.inorder(bt1);
		System.out.println();
		util.postorder(bt1);
		System.out.println();
		
		System.out.println(util.count(bt1));
		System.out.println(util.height(bt1));
		util.swap(bt1);
		
		util.preorder(bt1);
		System.out.println();
		System.out.println(util.leafNode(bt1));
	}
}