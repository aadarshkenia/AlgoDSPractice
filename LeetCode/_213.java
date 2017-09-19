class _213 {
	public static void main(String args[]) {
		
	}


	public int rob(int[] nums) {
        int n  = nums.length;
        int withoutEnds = 1 <= n-3 ? oldRob(nums, 1, n-3) : 0;
        int withEnds = oldRob(0, n-2);
        return Math.max(withEnds, withoutEnds + nums[n-1]);
    }

    //From solution to _198.java -> House Robber 
    public int oldrob(int[] nums, int startIndex, int endIndex) {
        int m1=0, m2=0;
        for(int i=endIndex; i >= startIndex; i--) {
            if(i == n-1) {
                m1 += nums[i]; 
            } else {
                if(nums[i] + m2 > m1) {
                    int temp = m1;
                    m1 = nums[i] + m2;
                    m2 = temp;
                } else {
                    m2 = m1;
                }
            }
        }
        return Math.max(m1, m2);
    }
}