package graph;
import java.util.List;
import java.util.ArrayList;

public class GraphNode<T> {
	protected T t;
	protected List<GraphNode<T>> nextNodes;

	public GraphNode(T t) {
		this.t = t;
	}

	public T getVal(){
		return t;
	}

	public void setVal(T t) {
		this.t = t;
	}

	public List<GraphNode<T>> getNextNodes() {
		return nextNodes;
	}

	public void setNextNodes(List<GraphNode<T>> nextNodes) {
		this.nextNodes = nextNodes;
	}

	public void addNextNode(GraphNode<T> node) {
		if(nextNodes == null) {
			nextNodes = new ArrayList<>();
		}
		nextNodes.add(node);
	}

}
