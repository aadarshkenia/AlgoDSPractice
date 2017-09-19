class _120 {
	public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle == null) {
        	return 0;
        }
        int n = triangle.size();
        int[][] buf = new int[n][n];
        for(int i = n-1 ;i >= 0; i--) {
    		List<Integer> list = triangle.get(i); 
        	if(i == n-1) {
        		for(int j=0; j < list.size(); j++) {
        			buf[i][j] = list.get(j);
        		}
        	} else {
        		for(int j=0; j < list.size(); j++) {
    				buf[i][j] = list.get(j) + Math.min(buf[i+1][j], buf[i+1][j+1]);        			
        		}
        	}
        }
        return buf[0][0];     
    }

}