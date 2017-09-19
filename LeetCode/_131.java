import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Arrays;
import java.util.stream.*;
class _131 {
	public static void main(String args[]){
		System.out.println("Input string as command line arg.");
		String s = args[0];
		System.out.println(new _131().partition(s));
	}

	public List<List<String>> partition(String s){
		int n = s.length();	
		//Array of list of strings
		List<List<String>> buf[] = new List[n + 1];	
		//Base case
		buf[n] = Arrays.asList(new ArrayList<>());
		for(int start = n-1; start >= 0; start--){
			String sub = s.substring(start, n);
			int sublen = sub.length();
			List<List<String>> curr = buf[start] != null ? buf[start] : new ArrayList();
			for(int i = sublen; i > 0 ; i--){
				String substr = sub.substring(0, i);
				if(isPalindrome(substr)){
					System.out.println(start + i);
					List<List<String>> sublist = clone(buf[start + i]);
					// System.out.println("buf["+(start+i)+"]="+sublist);
					sublist.forEach(l -> {
						l.add(0,substr);
					});
					// System.out.println("new sublist: " + sublist);
					curr.addAll(sublist);
				}
			}
			buf[start] = curr;
		} 	
		return buf[0];
	}

	private List<List<String>> clone(List<List<String>> l) {
		List<List<String>> res = new ArrayList<>();
		for(List<String> list : l){ 
			List<String> temp = new ArrayList<>();
			temp.addAll(list);				
			res.add(temp);
		}
		return res;
	}

	private boolean isPalindrome(String s) {
		int start=0, end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start++) != s.charAt(end--)) {
				return false;
			}
		}
		return true;
	}


}
