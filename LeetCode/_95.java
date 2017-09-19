import tree.TreeNode;
import java.util.List;
import java.util.ArrayList;
import java.util.stream.*;
class _95 {	
        
	public static void main(String args[]) {
		System.out.println(new _95().generateTrees(Integer.parseInt(args[0])).size());	
	}

	public List<TreeNode> generateTrees(int n) {
		if(n==0){
			return Collections.<TreeNode>emptyList();
		}
		Object[][] buf = new Object[n+1][n+1];
    	for(int j=1; j <= n; j++) {
    		int start = 1, end = start + j - 1;
    		while(end <= n) {    			
    			List<TreeNode> nodeList = new ArrayList<>();
    			if(end == start) {//Base case
    				nodeList.add(new TreeNode(start));    				
    			} else {
    				for(int k = start; k <= end; k++){ 
    					List<TreeNode> left = null, right = null;
    					if(k != start) {
    						left = (List<TreeNode>)buf[start][k-1];
    					}
    					if(k != end) {    					
    						right = (List<TreeNode>)buf[k+1][end];  
    					}
    					List<TreeNode> combinedList = combine(left, right, k);
    					nodeList.addAll(combinedList);
    				}
    			}
    			buf[start][end] = nodeList;
    			// System.out.println("For start="  + start + " end=" + end + " list:" + nodeList);
    			start++;
    			end++;
    		}
    	}
    	return (List<TreeNode>)buf[1][n];
    }

    private List<TreeNode> combine(List<TreeNode> left, List<TreeNode> right, int k) {
    	
    	List<TreeNode> combined = new ArrayList<>();
    	if(left != null && right != null) {
    		//Combine left plus right
	    	for(TreeNode leftRoot : left) {
	    		for(TreeNode rightRoot : right) {
	    			TreeNode treeRoot = new TreeNode(k);
	    			treeRoot.left = leftRoot;
	    			treeRoot.right = rightRoot;
	    			combined.add(treeRoot);
	    		}
	    	}	
    	} else if(left != null) { //Add all trees with nodes less than k as left subtrees of the tree whose root is k.
    		combined.addAll(left.stream()
    					.map(treeRoot -> {
    						TreeNode tn = new TreeNode(k);
    						tn.left = treeRoot;
    						return tn;
    					})
    					.collect(Collectors.toList()));
    	} else if(right != null) {
    		combined.addAll(right.stream()
    					.map(treeRoot -> {
    						TreeNode tn = new TreeNode(k);
    						tn.right = treeRoot;
    						return tn;
    					})
    					.collect(Collectors.toList()));	
    	}
    	
    		
    	return combined;
    }
}