import tree.TreeNode;
class _513 {
	public int findBottomLeftValue(TreeNode root) {
        return findBottomLeftValueHelper(root, 1).val;
    }

    private Pair findBottomLeftValueHelper(TreeNode root, int ht) {
        if(root.left == null && root.right == null) {
        	return new Pair(ht, root.val);
        } else if(root.left == null) {
        	return findBottomLeftValueHelper(root.right, ht+1);
        } else if(root.right == null) {
        	return findBottomLeftValueHelper(root.left, ht+1);
        } else {
        	Pair leftPair = findBottomLeftValueHelper(root.left, ht+1);
        	Pair rightPair = findBottomLeftValueHelper(root.right, ht+1);
        	if(leftPair.height >= rightPair.height) {
        		return leftPair;
        	} else {
        		return rightPair;
        	}
        }
    }

    private class Pair{
    	int height;
    	int val;
    	Pair(int h, int v) {
    		height = h;
    		val = v;
    	}
    }
}