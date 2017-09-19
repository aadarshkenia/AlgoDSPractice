import tree.*;
import java.util.Stack;
class _173 {
	public static void main(String args[]) {
		TreeNode root = new TreeNode(2);
		root.left = new TreeNode(1);
		root.right = new TreeNode(3);
		BSTIterator iterator = new BSTIterator(root);
		System.out.println(iterator.next());
		System.out.println(iterator.next());
		System.out.println(iterator.next());
	}
}

class BSTIterator {
	static Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
    	stack = new Stack<>();
    	traverseLeftNodes(root);    	
    	System.out.println(stack);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.empty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode current = stack.pop();
        if(current.right != null) {
        	traverseLeftNodes(current.right);	
        }
        return current.val;
    }

    //Traverse left nodes and push to stack
    private void traverseLeftNodes(TreeNode root) {
    	TreeNode temp = root;
    	while(temp != null) {
    		stack.push(temp);
    		temp = temp.left;
    	}  
    }
}