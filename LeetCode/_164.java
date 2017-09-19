import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
class _164 {
	public static void main(String args[]) {
		int x[] = {1,5,20,6,17,8,10};
		System.out.println(new _164().maximumGap(x));
	}


	public int maximumGap(int[] nums) {
    	int n = nums.length;
    	if(n < 1) {
    		return 0;
    	}
    	int min = nums[0], max = nums[0];
    	//Compute min and max
    	for(int i : nums){
    		if(i < min){
    			min = i;
    		} else if(i > max) {
    			max = i;
    		}

    	}

    	int intervalSize = (int)Math.ceil((max - min + 1)/(double)n);

    	//Initialize the buckets.
		List<List<Integer>> buckets = new ArrayList<>(n);    	
		for(int i=0; i < n; i++){
			buckets.add(i, new ArrayList<>(intervalSize));
		}

		//Insert elems into bucket.
		for(int x : nums) {
			int bucketNum = (x - min)/intervalSize;	
			System.out.println("Inserting elem: " + x);
			buckets.get(bucketNum).add(x);
		}

		//Sort the individual buckets.
		for(List<Integer> bucket : buckets) {
			Collections.sort(bucket);
		}

		//Compute max diff.
		int ans = Integer.MIN_VALUE;
		List<Integer> prevBucket = null;
		for(List<Integer> bucket : buckets) {
			if(bucket.size() == 0) {
				continue;
			}
			if(prevBucket != null) {
				int diff = bucket.get(0) - prevBucket.get(prevBucket.size()-1);
				if(diff > ans) 
					ans = diff; 
			}
			for(int i=0; i < bucket.size() - 1; i++) {
				int diff = bucket.get(i+1) - bucket.get(i);
				if(diff > ans) 
					ans = diff; 
			}
			prevBucket = bucket;
		}

		return ans;
    }

    
}