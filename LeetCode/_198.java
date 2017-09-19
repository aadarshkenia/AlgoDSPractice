public class _198 {
    public int rob(int[] nums) {
        int n = nums.length;
        int m1=0, m2=0;
        for(int i=n-1; i >= 0; i--) {
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