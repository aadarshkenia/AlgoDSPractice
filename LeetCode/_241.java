import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class _241 {

	public static void main(String args[]) {
		String input = args[0];
		System.out.println(new _241().diffWaysToCompute(input));
	}

	public List<Integer> diffWaysToCompute(String input) {
        Map<String, List<Integer>> buf = new HashMap<>();
        return diffWaysToCompute(input, buf);
    }

	public List<Integer> diffWaysToCompute(String input, Map<String, List<Integer>> buffer) {    	
    	List<Integer> ans = new ArrayList<>();
    	char ch[] = input.toCharArray();
    	int opCount = 0;
    	for(int i=1; i < input.length() - 1; i++) {
    		if(ch[i] == '*' || ch[i] == '+' || ch[i] == '-') {
    			opCount++;
    			String left = input.substring(0, i);
    			String right = input.substring(i + 1);
    			List<Integer> leftList = buffer.containsKey(left) ? buffer.get(left) : diffWaysToCompute(left, buffer);
    			List<Integer> rightList = buffer.containsKey(right) ? buffer.get(right) : diffWaysToCompute(right, buffer);
    			if(ch[i] == '*'){
    				ans.addAll(combineMult(leftList, rightList));
    			} else if(ch[i] == '+') {
    				ans.addAll(combineAdd(leftList, rightList));
    			} else {
    				ans.addAll(combineSub(leftList, rightList));
    			}	
    		}
    	}
    	if(opCount == 0) {
    		ans.add(Integer.parseInt(input));
    	}
    	buffer.put(input, ans);
    	return ans;
    }

    public List<Integer> combineMult(List<Integer> l1, List<Integer> l2) {
    	List<Integer> ans = new ArrayList<>();
    	for(int i : l1) {
    		for(int j : l2) {
				ans.add(i * j);    			
    		}
    	}
    	return ans;
    }

    public List<Integer> combineAdd(List<Integer> l1, List<Integer> l2) {
    	List<Integer> ans = new ArrayList<>();
    	for(int i : l1) {
    		for(int j : l2) {
				ans.add(i + j);    			
    		}
    	}
    	return ans;
    }

    public List<Integer> combineSub(List<Integer> l1, List<Integer> l2) {
    	List<Integer> ans = new ArrayList<>();
    	for(int i : l1) {
    		for(int j : l2) {
				ans.add(i - j);    			
    		}
    	}
    	return ans;
    }
}