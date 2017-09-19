class _668 {

	public static void main(String args[]) {
		System.out.println("Ans=" + new _668().findKthNumber(4, 4, 13));
	}

	public int findKthNumber(int m, int n, int k) {
     	int lo = 1, hi = k;
     	while(lo <= hi) {
     		int mid = lo + (hi-lo)/2;
     		int count = 0;
	    	int exactDivisors = 0;
	    	for(int i = 1; i <= n; i++) {
	    		count += Math.min(mid / i, m);
	    		if(mid % i == 0 && mid / i <= m) exactDivisors++;
	    	}
    		System.out.println(String.format("lo=%d hi=%d mid=%d count=%d exactDivisors=%d", lo, hi, mid, count, exactDivisors));
    		if(count >= k) {
    			if(exactDivisors != 0 && (count - exactDivisors) < k)
    				return mid;
    			else 
    				hi = mid-1;
    		} else if(count > k) {
    			hi = mid - 1;
    		} else {
    			lo = mid + 1;
    		}

     	}
     	return -1;   
    }

    private int count(int num, int n) {
    	int count = 0;
    	for(int i = 1; i <= n; i++) {
    		count += num / i;
    	}
    	return count;
    }
}