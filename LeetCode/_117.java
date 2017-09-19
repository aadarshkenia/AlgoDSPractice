import java.util.Map;
import java.util.HashMap;
class _117 {
	public static void main(String args[]) {

		int x[] = {2,1,3,0,7,9,1,2,-1, 1,0,-1,-1,8,8,-1,-1,-1,-1, 7};
		TreeLinkNode root = createTree(x);

		new _117().connect(root);
	}
	private static TreeLinkNode createTree(int x[]) {
		
		Map<Integer, TreeLinkNode> map = new HashMap<>();
		int n = x.length;
		for(int i=0; i < n; i++) {
			if(i == -1)
				continue;
			TreeLinkNode node = null;
			if(map.containsKey(i)){
				node = map.get(i);
			}
			else{
				node = new TreeLinkNode(x[i]);
				map.put(i, node);
			}
			
			int left = 2*i + 1;
			int right = left + 1;
			if(left < n && x[left] != -1){
				if(map.containsKey(left)) {
					TreeLinkNode ln = map.get(left);
					node.left = ln;	
				} else {
					TreeLinkNode ln = new TreeLinkNode(x[left]);
					node.left = ln;
					map.put(left, ln);
				}				
			}
			if(right < n && x[right] != -1){
				if(map.containsKey(right)) {
					TreeLinkNode rn = map.get(right);
					node.right = rn;	
				} else {
					TreeLinkNode rn = new TreeLinkNode(x[right]);
					node.right = rn;
					map.put(right, rn);
				}				
			}
		}
		return map.get(0);
	}


	public void connect(TreeLinkNode root) {
		
    	if(root == null) {
    		return;
    	}
    	
    	TreeLinkNode temp = root, nextLevelnode = null;
    	while(temp != null) {
    		// System.out.println(temp.val);
    		TreeLinkNode leftChild = temp.left, rightChild = temp.right;    		
    		if(nextLevelnode == null) {
    			nextLevelnode = temp.left != null ? temp.left : temp.right;
    		}

    		if(leftChild != null) {
    			leftChild.next = rightChild != null ? rightChild : findDest(temp.next);
    		} 
    		if(rightChild != null) {
    			rightChild.next = findDest(temp.next);
    		}

	    	//Update temp
	    	if(temp.next == null){
	    		temp = nextLevelnode;
	    		nextLevelnode = null;
	    	}
	    	else {
	    		temp = temp.next;
	    	}
    	}


    }

    private TreeLinkNode findDest(TreeLinkNode start) {
    	while(start != null) {
    		if(start.left != null) {
    			return start.left;
    		}
    		if(start.right != null) {
    			return start.right;
    		}
    		start = start.next;
    	}
    	return null;
    }

    static class TreeLinkNode {    	
		int val;
      	TreeLinkNode left, right, next;
 		TreeLinkNode(int x) { val = x; }
 		TreeLinkNode(int x, TreeLinkNode left, TreeLinkNode right) { val = x; this.left = left; this.right = right;}
 		@Override
 		public String toString() {
 			String s = "" + val;
 			if(left != null)
 				s = s + " left:" + left.val;
 			if(right != null)
 				s = s + " right:" + right.val;
 			return s;
 		}
    }
}