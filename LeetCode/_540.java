class _540 {
	public static void main(String args[]) {
		int x[] = {1, 1, 2, 2, 3};
		int ans = new _540().singleNonDuplicate(x);
		System.out.println(ans);
	}
	
	public int singleNonDuplicate(int[] nums) {
		int n = nums.length;
		int low = 0, high = n-1;
		while(low < high) {
			int mid = low + (high - low)/2;
			if(nums[mid] == nums[mid + 1]) {
				int numRight = high - mid + 1; //Number of elements to the right including this elem
				if(numRight % 2 == 0) {
					high = mid - 1;
				} else {
					low = mid + 2;
				}

			} else if (nums[mid] == nums[mid - 1]) {
				int numLeft = mid - low + 1;
				if(numLeft % 2 == 0) {
					low = mid + 1;	
				} else {
					high = mid - 2;
				}
			} else {
				return nums[mid];
			}
		}
		return nums[low];
	}
	
}
