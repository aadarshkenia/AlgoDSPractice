class _114 {

	public void flatten(TreeNode root) {
    	flattenHelper(root);
    	return root;	    
    }    

    //Returns the last TreeNode visited.
    private TreeNode flattenHelper(TreeNode t) {
    	if(t == null){
    		return null;
    	}
    	TreeNode rs = flattenHelper(t.right);
    	TreeNode ls = flattenHelper(r.left);

    	TreeNode lastVisited = ls != null ? ls : t;
    	lastVisited.right = t.right;
    	lastVisited = rs != null ? rs : t;
    	//Set left node to null in flattened tree
    	t.left = null;
    	return lastVisited;
    }
}