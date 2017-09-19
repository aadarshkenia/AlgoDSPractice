class _304 {
	
}

class NumMatrix {
    private static long sum[][];
	boolean isValid = true;
	public NumMatrix(int[][] matrix) {
    	int nr = matrix.length;
    	isValid = nr > 0;
    	int nc = isValid ? matrix[0].length: 0;

    	sum = new long[nr + 1][nc + 1];
    	for(int i=0; i < nr; i++) {
    		for(int j=0; j < nc; j++) {
    			sum[i+1][j+1] = (long)sum[i][j+1] + (long)sum[i+1][j] - (long)sum[i][j];
    		}
    	}	    
    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(!isValid) {
        	return (int)(sum[row2+1][col2+1] + sum[row1][col2+1] - sum[row1+1][col2]- sum[row1][col1]);
        }
        return 0;
    }
}
