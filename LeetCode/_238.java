class _238 {
	public int[] productExceptSelf(int[] nums) {
    	int n = nums.length;
    	int output[] = new int[n];
    	output[0] = 1;
    	for(int i=0; i < n; i++) {
    		output[i] *= nums[i];    		
    	}
    	int rightMultiplier = 1;
    	for(int i = n - 1; i >= 0; i--) {
    		output[i] *= rightMultiplier;
    		rightMultiplier *= nums[i];
    	}
    	return output;     
    }

}