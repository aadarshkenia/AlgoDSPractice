class _307 {
	public static void main(String args[]) {
		int x[] = {1,2,3,4,5};
		NumArray numArray = new NumArray(x); 
		System.out.println(numArray.sumRange(0,4));
		numArray.update(4,6);
		System.out.println(numArray.sumRange(0,4));
	}
}

class NumArray {
	static long[] segmentTree;
	static int len;
	static int[] numsRef;
    public NumArray(int[] nums) {
    	int n = nums.length;
    	len = n;
    	numsRef = nums;
    	double levels = Math.ceil(Math.log((double)n) / Math.log(2.0));
    	int arrSize = (int)Math.pow(2.0, levels + 1) - 1;
    	segmentTree = new long[arrSize];
    	build(nums, 0, n-1, 0);
    }
    
    public void update(int i, int val) {
        updateUtil(i, val - numsRef[i], 0, 0, len - 1);
    }

    private void updateUtil(int i, int diff, int currentNodeIdx, int nodeStartIdx, int nodeEndIdx) {
    	segmentTree[currentNodeIdx] += diff;
    	if(nodeStartIdx >= nodeEndIdx) {
    		return;
    	}
    	int mid = nodeStartIdx + (nodeEndIdx - nodeStartIdx) / 2;
    	if(i <= mid) {
    		updateUtil(i, diff, 2 * currentNodeIdx + 1, nodeStartIdx, mid);
    	} else {
    		updateUtil(i, diff, 2 * currentNodeIdx + 2, mid + 1, nodeEndIdx);
    	}
    }
    
    public int sumRange(int i, int j) {
        return sumRangeUtil(i, j, 0, 0, len-1);
    }

    private int sumRangeUtil(int i, int j, int currentIndex, int nodeStartIdx, int nodeEndIdx) {
    	if(nodeStartIdx >= i && nodeEndIdx <= j) {
    		return (int)segmentTree[currentIndex];
    	} else if(nodeStartIdx > j || nodeEndIdx < i) {
    		return 0;
    	} else {
    		int mid = nodeStartIdx + (nodeEndIdx - nodeStartIdx)/2;
    		return sumRangeUtil(i, j, 2*currentIndex + 1, nodeStartIdx, mid) +
    					sumRangeUtil(i, j, 2*currentIndex + 2, mid+1, nodeEndIdx);
    	}
    }

    //Util to build segment tree
    private long build(int arr[], int lo, int hi, int idx) {
    	if(lo == hi) {
    		segmentTree[idx] = arr[lo];
    		return arr[lo];
    	} 
    	int mid = lo + (hi - lo)/2;
    	segmentTree[idx] = build(arr, lo, mid, 2*idx + 1) + build(arr, mid + 1, hi, 2*idx + 2);
    	return segmentTree[idx];
    }

    private void printArr(long a[]) {
    	for(int i = 0; i < a.length; i++) {
    		System.out.print(a[i] + " ");
    	}
    	System.out.println();
    }

}