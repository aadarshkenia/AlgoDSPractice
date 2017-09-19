class _81 {
	public static void main(String args[]) {
		int nums[] = {1,1,3,1};
		int target=3;
		System.out.println("Ans=" + new _81().search(nums, target));
	}


	public boolean search(int[] nums, int target) {
		return search(nums, 0, nums.length - 1, target);
	}


	public boolean search(int[] nums, int startIdx, int endIdx, int target) {
     	if(startIdx > endIdx) {
     		return false;
     	}

     	int mid = startIdx + (endIdx - startIdx)/2;
     	// System.out.println(String.format("startIdx=%d endIdx=%d target=%d", startIdx, endIdx, target));
     	if(target == nums[mid]) {
 			return true;
 		} else if (nums[mid] > nums[endIdx]) {//mid is in the range (x-i....x-i+1....x-n) 
 			if(target < nums[mid]) {
 				if(target < nums[startIdx]) {
 					return search(nums, mid + 1, endIdx, target);
 				} else if(target == nums[startIdx]) {
 					return true;
 				} else {
 					return search(nums, startIdx, mid - 1, target);
 				}
 			}
 			else {
 				return search(nums, mid + 1, endIdx, target);
 			}
 		} else if(nums[mid] == nums[endIdx]) {
 			return search(nums, startIdx, mid-1, target)  || search(nums, mid+1, endIdx, target);
 		} else {
 			if(target < nums[mid]) {
 				return search(nums, startIdx, mid-1, target);
 			} else {
 				if(target > nums[endIdx]) {
 					return search(nums, startIdx, mid-1, target);
 				} else if(target == nums[endIdx]) {
 					return true;
 				} else {
 					return search(nums, mid+1, endIdx, target);
 				}	
 			}
 		}

    }//end of function
}