class _153 {
	public static void main(String args[]) {
		int x[] = {7,8,2,3,5,6};
		System.out.println(new _153().findMin(x));
	}

	public int findMin(int[] nums) {
		int lo = 0, hi = nums.length - 1;
		while(lo <= hi ) {
			if(lo == hi){
				return nums[lo];
			}
			int mid = lo + (hi - lo) / 2;
			boolean isMidSmallest = true;
			if(mid != lo && nums[mid] > nums[mid - 1]) {
				isMidSmallest = false;
			}
			if(mid != hi && nums[mid] > nums[mid + 1]) {			
				isMidSmallest = false;
			}
			if(isMidSmallest) {
				return nums[mid];
			} else {
				if(nums[mid] > nums[hi]) {
					lo = mid + 1;
				} else if(nums[mid] < nums[lo]) {
					hi = mid - 1;
				} else {
					return nums[lo];
				}
			}
		}
		throw new RuntimeException("Should never reach here");
	}
}
