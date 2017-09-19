class _108 {
	
	public TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTHelper(nums, 0, nums.length - 1);	
	}

	public TreeNode sortedArrayToBSTHelper(int[] nums, int lo, int hi) {
		if(lo >  hi) {
			return null;
		}
		int mid = lo + (hi - lo) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = sortedArrayToBSTHelper(nums, lo, mid - 1);
		root.right = sortedArrayToBSTHelper(nums, mid + 1, hi);
		return root;
	}
}
