class _670 {
	public int maximumSwap(int num) {
        char c[] = Integer.toString(num).toCharArray();        
    	int n = c.length;
    	for(int i = 0; i < n-1; i++) {
    		char max = c[i];
    		int maxIdx = i;
    		for(int j = i+1; j < n; j++) {
    			if(c[j] > max){
    				max = c[j];
    				maxIdx = j;
    			}
    		}
    		if(max != c[i]) {
    			c[maxIdx] = c[i];
    			c[i] = max;
    			return Integer.parseInt(new String(c));
    		}
    	}
    	return num;
    }
}