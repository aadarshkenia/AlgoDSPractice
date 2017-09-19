import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class _446 {
	public static void main(String args[]) {
		int a[] = {1,1,1,1,1,1};
		System.out.println(new _446().numberOfArithmeticSlices(a));
	}
	public int numberOfArithmeticSlices(int[] A) {
		int n = A.length;
		List<Map<Long, Integer>> buf = new ArrayList<>();
		int ans = 0;
		buf.add(0, new HashMap<Long, Integer>());
		for(int i=1; i < n; i++) {
			Map<Long, Integer> currentMap = new HashMap<Long, Integer>();
			for(int j=i-1; j>=0; j--) {				
				long diff = (long)A[i] - (long)A[j];				
				Map<Long, Integer> prevMap = buf.get(j);
				if(prevMap.containsKey(diff)) {
					int temp = currentMap.getOrDefault(diff, 0);
					temp += (prevMap.get(diff) + 1);
					ans+= prevMap.get(diff);
					currentMap.put(diff, temp);					
				} else {
					if(!currentMap.containsKey(diff)) {
						currentMap.put(diff, 1);
					} else {
						int temp = currentMap.get(diff);
						currentMap.put(diff, temp+1);
					}					
				}
				System.out.println("For i="+i+" j="+j+" currentMap:"+currentMap);
			}
			buf.add(currentMap);
			System.out.println(buf.get(i));
		}
		return ans;    
    }
}