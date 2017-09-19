class _174 {
	public int calculateMinimumHP(int[][] dungeon) {
    	int m = dungeon.length;
    	if(m <0) {
    		return 0;
    	}
    	int n = dungeon[0].length;

    	int buf[][] = new int[m][n];
    	//Base case: Compute last column 
    	buf[m-1][n-1] = dungeon[m-1][n-1] < 0 ? -dungeon[m-1][n-1] : 0;
    	for(int i = m - 2; i >= 0; i--) {
    		buf[i][n-1] = Math.max(buf[i+1][n-1] - dungeon[i][n-1], 0);
    	}

    	//Base case: Compute last row
    	for(int j = n - 2; j >= 0; j--) {
    		buf[m-1][j] = Math.max(buf[m-1][j+1] - dungeon[m-1][j], 0);
    	}

    	//Fill up remaining cells.
    	for(int j = n-2; j >= 0; j--) {
    		for(int i = m-2; i >= 0; i--) {
    			int min = Math.min(buf[i+1][j], buf[i][j+1]);
    			buf[i][j] = Math.max(min - dungeon[i][j], 0);
    		}
    	}

    	return buf[0][0] + 1;
    }
}