import java.util.Queue;
import java.util.LinkedList;
class _200 {
	static final int[][] diff = {{1,0}, {0,1}, {-1,0}, {0,-1}};
	public int numIslands(char[][] grid) {
    	int r = grid.length;
    	if(r == 0) return 0;
    	int c = grid[0].length;
    	int ans = 0;
    	for(int i=0; i < r; i++){ 
    		for(int j=0; j < c; j++) {
    			if(grid[i][j] == 1) {
    				processPoint(grid, i, j, r, c);
    				ans++;
    			}
    		}
    	}
    	return ans;
    }		

    private void processPoint(char[][] grid, int i, int j, int r, int c) {
		for(int[] d : diff) {
			int nr = d[0] + i;
			int nc = d[1] + j;
			grid[i][j] = 0;
			if(nr >= 0 && nr < r && nc >=0 && nc < c && grid[nr][nc] == 1) {
				processPoint(grid, nr, nc, r, c);
			}
		} 	
    }

}