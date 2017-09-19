import java.util.*;
class _675 {
	static final int[][] diff = {{0,0}, {0,1}, {1,0}, {1,1}};
	static PriorityQueue<Tree> pq;
	static int matrix[][];
	static int r;
	static int c;


	public int cutOffTree(List<List<Integer>> forest) {
    	int n = forest.size();
    	int m = forest.get(0).size();
    	r = n;
    	c = m;
    	pq = new PriorityQueue<>(n*m, (t1, t2) -> {return new Integer(t1.ht).compareTo(t2.ht);});
    	matrix = new int[n][m];
    	for(int i=0; i < n; i++) {
    		List<Integer> row = forest.get(i);
    		for(int j=0; j < m; j++) {
    			int ht = row.get(j); 
    			if(ht > 1) {
    				pq.add(new Tree(i, j, ht));	
    			}
    			matrix[i][j] = ht;
    		}
    	}
    	int ans = 0;
    	Tree prev = new Tree(0, 0, 0);
    	while(pq.size() != 0) {
    		Tree curr = pq.poll();
    		System.out.println(curr);
    		int dist = bfs(prev.row, prev.col, curr.row, curr.col);
    		if(dist == -1)
    			return -1;
    		System.out.println("dist="+dist);
    		ans += dist;	
    		prev = curr;
    	}
    	return ans;
    	
    }

    private int bfs(int x1, int y1, int x2, int y2) {
    	if(x1 == x2 && y1 == y2) {
    		return 0;
    	}
    	boolean vis[][] = new boolean[r][c];
    	vis[x1][y1] = true;
    	int ans = 0;
    	int start[] = new int[2];
    	start[0] = x1;
    	start[1] = y1;
    	Queue<int[]> queue = new LinkedList<>();
    	queue.add(start);
    	while(!queue.isEmpty()) {
    		int size = queue.size();
    		for(int i = 0; i < size; i++) {
    			int[] curr = queue.poll();
	    		if(curr[0] == x2 && curr[1] == y2) {
	    			return ans;
	    		}
	    		for(int d[] : diff) {
	    			int next[] = new int[2];
	    			next[0] = curr[0] + d[0];
	    			next[1] = curr[1] + d[1];
	    			if(next[0] < 0 || next[0] >= r || next[1] < 0 || next[1] >= c || vis[next[0]][next[1]] || matrix[next[0]][next[1]] == 0) continue;
	    			queue.add(next);
	    			vis[next[0]][next[1]] = true;
	    		}	
    		}
    		ans++;
		}
		return -1;
    }


}

class Tree {
	int row;
	int col;
	int ht;
	public Tree(int row, int col, int ht) {
		this.row = row;
		this.col = col;
		this.ht = ht;
	}

	@Override
	public String toString() {
		return String.format("row=%d col=%d ht=%d", row, col, ht);
	}
}