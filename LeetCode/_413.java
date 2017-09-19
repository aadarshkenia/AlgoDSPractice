class _413 {
	public static void main(String args[]) {
		int A[] = {1,2,3,10,11,12,13};
		System.out.println(new _413().numberOfArithmeticSlices(A));
	}

	public int numberOfArithmeticSlices(int[] A) {
    	int n = A.length;
    	if(n < 3){
    		return 0;        
    	}
    	int ans = 0;
    	int numSeqEndingAtLastIndex = (A[1] - A[0]) == (A[2] - A[1]) ? 1 : 0;
    	int lastDiff = A[2] - A[1];
    	ans += numSeqEndingAtLastIndex;
    	for(int i = 3; i < n; i++) {
		 	if(lastDiff == (A[i] - A[i-1])) {
				numSeqEndingAtLastIndex += 1;
			} else {
				numSeqEndingAtLastIndex = 0;
			}			 
			lastDiff = A[i] - A[i-1];
			ans += numSeqEndingAtLastIndex;    		
    	}
    	return ans;
	}
}