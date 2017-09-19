class _260 {
	public static void main(String args[]) {
		int nums[] = {1,1,2,2,3,3,4,5,5,6};
		int ans[] = new _260().singleNumber(nums);
		System.out.println(ans[0] + " " + ans[1]);
	}

	public int[] singleNumber(int[] nums) {
    	int xor = 0;
    	for(int i : nums) {
    		xor ^=  i;
    	}

    	//Find any set bit in xor (say rightmost)
    	int counter = 0;
    	while((xor>>counter & 1) == 0) {
    		counter++;
    	}

    	int g1_xor = 0, g2_xor = 0;
    	for(int i : nums) {
    		if((i>>counter & 1) == 1) {
    			g1_xor ^= i;
    		} else {
    			g2_xor ^= i;
    		}
    	}
    	int ans[] = {g1_xor, g2_xor};
    	return ans;	     
    }
}