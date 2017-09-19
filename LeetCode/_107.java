import java.util.List;
import java.util.ArrayList;

class _107 {
	
	public static void main(String args[]) {
		
	}

	public List<List<Integer>> levelOrderBottom(TreeNode n) {
		List<List<Integer>> ans = new ArrayList<>();
		traverse(n, 0, ans);
		return ans;
	}

	public void traverse(TreeNode n, int height, List<List<Integer>> ans) {
		if(n == null) {
			return;
		}
		if(ans.size() -1 < height) {
			ans.add(new ArrayList<Integer>());
		}
		//Left recurse
		traverse(n.left, height + 1, ans);
		//Right recurse
		traverse(n.right, height + 1, ans);
		
		List<Integer> currentLevelList = ans.get(ans.size() - height - 1);
		currentLevelList.add(n.val);
	}

	public class TreeNode {
		int val;
		TreeNode left;
	   	TreeNode right;
	    TreeNode(int x) { val = x; }
	}
}
