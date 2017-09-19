package tree;
public class TreeNode{
	public int val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val){
		this.val = val;
	}

	public TreeNode(int val, TreeNode left, TreeNode right){
		this.left = left;
		this.right = right;
	}

	@Override
	public String toString() {
		String str = "Val:" + val;
		return str;
	}
}

