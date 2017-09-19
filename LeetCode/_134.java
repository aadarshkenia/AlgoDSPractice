class _134 {
	public static void main(String args[]) {
		// int g[] = {2,3,1};
		int g[] = {2,0,1,2,3,4,0};
		int c[] = {0,1,0,0,0,0,11};
		// int c[] = {3,1,2};
		System.out.println(new _134().canCompleteCircuit(g, c));
	}

	public int canCompleteCircuit(int[] gas, int[] cost) {
    	long cumDelta=0;
    	long localDelta=0;
    	int start = 0, n = gas.length;
    	
    	for(int i=0; i < n; i++) {
    		int diff = gas[i] - cost[i];    		
    		if(localDelta < 0 && diff > 0) {
    			start = i;
    		} else {
    			localDelta += diff;
    		}
    	}
    	cumDelta += diff;

    	if(cumDelta < 0)
    		return -1;
    	return start;
    }
}