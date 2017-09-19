class _303{
	public static void main(String args[]) {
		int x[] = {-2, 0, 3, -5, 2, -1};
		NumArray num = new NumArray(x);
		System.out.println(num.sumRange(1,5));
		System.out.println(num.sumRange(0,5));
		System.out.println(num.sumRange(5,5));
		System.out.println(num.sumRange(0,0));

	}
}

class NumArray {
    static long[] cumulative;
    public NumArray(int[] nums) {
        int n = nums.length;
        if(n > 0) {
            cumulative = new long[n+1];
            for(int i=1; i <= n; i++) {
                cumulative[i] = cumulative[i-1] + (long)nums[i-1];
            }    
        }        
    }
    
    public int sumRange(int i, int j) {
        if(cumulative != null) {
            return (int)(cumulative[j+1] - cumulative[i]);
        }
        return 0;
    }
}