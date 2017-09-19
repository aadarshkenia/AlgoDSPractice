//SOLUTION BASED ON MOST ACCEPTED SOLUTION, USES SIMPLE INORDER TRAVERSAL.


import tree.TreeNode;
class _99 {

	static TreeNode first, second, prev;
	public void recoverTree(TreeNode root) {
		first = null;
		second = null;
		prev = null;
		if(root != null) {
			inOrder(root);
			exchange(first, second);
		}
	}
	
	//Returns the last node visited
	private void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		//Left recursion
		inOrder(root.left);

		if(prev != null) {
			if(prev.val > root.val) {
				if(first == null && second == null) {
					first = prev;
					second = root;
				} else {					
					second = root;
				}
			}
		} 
		prev = root;
		
		//Right recursion
		inOrder(root.right);
	}
	

	//Interchange values of nodes
	private void exchange(TreeNode first, TreeNode second) {
		assert first != null;
		assert second != null;
		int temp = first.val;
		first.val = second.val;
		second.val = temp;
	}
}
