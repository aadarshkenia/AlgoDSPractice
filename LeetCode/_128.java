import java.util.HashMap;
import java.util.Map;

class _128 {
	public static void main(String args[]) {
		int x[] = {100, 1, 4, 3, 200, 2, 5};
		System.out.println(new _128().longestConsecutive(x));
	}
	
	public int longestConsecutive(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		if(nums == null || nums.length < 1)
			return 0;
		int maxLen = 1;
		for(int i=0; i < nums.length; i++) {
			int x = nums[i];
			if(!map.containsKey(x)) {
				int left = x-1;
				int right = x+1;
				int leftChainLength = 0;
				int rightChainLength = 0;
				if(map.containsKey(left)) {
					leftChainLength = map.get(left);
				}
				if(map.containsKey(right)) {
					rightChainLength = map.get(right);
				}
				int currentChainLength = leftChainLength + rightChainLength + 1;
				if(currentChainLength > maxLen) {
					maxLen = currentChainLength;
				} 
				map.put(x, currentChainLength);
				if(leftChainLength > 0) {
					map.put(x - leftChainLength, currentChainLength);					
				}
				if(rightChainLength > 0){
					map.put(x + rightChainLength, currentChainLength);
				}
			}	
		}
		//System.out.println(map);
		return maxLen;
	}
}	
