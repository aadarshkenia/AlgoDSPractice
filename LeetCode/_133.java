import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class _133 {

	public static void main(String args[]) {
		UndirectedGraphNode root = new UndirectedGraphNode(0);
		root.neighbors = Arrays.asList(root);
		System.out.println(new _133().cloneGraph(root));
	}

    static Map<UndirectedGraphNode, UndirectedGraphNode> originalToCloneMap;

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		originalToCloneMap = new HashMap<>();
		UndirectedGraphNode rootClone = new UndirectedGraphNode(node.label);
		originalToCloneMap.put(node, rootClone);
		cloneNode(node, new HashSet<>());
    	return rootClone;
    }

    public void cloneNode(UndirectedGraphNode node, Set<UndirectedGraphNode> visited) {
    	visited.add(node);
    	//Get corresponding clone for this node
    	UndirectedGraphNode clone  = originalToCloneMap.get(node);
    	List<UndirectedGraphNode> clonedNeighbors = new ArrayList<>();
    	for(UndirectedGraphNode neighbor : node.neighbors) {
    		System.out.println("Current neighbor: " + neighbor);
    		UndirectedGraphNode clonedNeighbor = null;
    		if(originalToCloneMap.containsKey(neighbor)) {
    			clonedNeighbor = originalToCloneMap.get(neighbor);
    		} else {
    			clonedNeighbor = new UndirectedGraphNode(neighbor.label);
    			originalToCloneMap.put(neighbor, clonedNeighbor);
    		}
    		clonedNeighbors.add(clonedNeighbor);
    		if(!visited.contains(neighbor)) {
    			cloneNode(neighbor, visited);	
    		}    		
    	}
    	//System.out.println(clonedNeighbors);
    	clone.neighbors = clonedNeighbors; 
	}


    static class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
  		
  		@Override
  		public String toString() {
  			return Integer.toString(label);
  		}
  	};
}