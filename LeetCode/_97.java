import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
class _97 {
	public static void main(String args[]){
		System.out.println(new _97().isInterleave(args[0], args[1], args[2]));	
	}
	/*
	public boolean isInterleave(String s1, String s2, String s3, Map<Triplet, Boolean> cache){
		Triplet triplet = new Triplet(s1, s2, s3);
		//Base case
		if(s1.equals("")) {
			boolean ans = s2.equals(s3);
			cache.put(triplet, ans);
			return ans;
		} else if(s2.equals("")) {
			boolean ans = s1.equals(s3);
			cache.put(triplet, ans);
			return ans;
		} 

		boolean ans=false;	
		//Recursive case
		if(s1.charAt(0) == s3.charAt(0)) {
			String s1_n = s1.substring(1);
			String s3_n = s3.substring(1);
			Triplet t1 = new Triplet(s1_n, s2, s3);
			ans = cache.containsKey(t1) ? cache.get(t1) : isInterleave(s1_n, s2, s3_n, cache);
		}
		if(!ans && s2.charAt(0) == s3.charAt(0)) {
			String s2_n = s2.substring(1);
			String s3_n = s3.substring(1);
			Triplet t2 = new Triplet(s1, s2_n, s3);
			ans = cache.containsKey(t2) ? cache.get(t2) : isInterleave(s1, s2_n, s3_n, cache);
		}
		cache.put(triplet, ans);
		return ans;
	}*/


	//TODO: Optimize this tomorrow
	public boolean isInterleave(String s1, String s2, String s3) {
		int n1 = s1.length(), n2 = s2.length(), n3 = s3.length();
		if(n1 + n2 != n3) {
			return false;
		}
		Set<Pair> buf = new HashSet<>();
		buf.add(new Pair("", ""));
		//Iterate each character of s3 from end	
		for(int i = n3 - 1; i >=0; i--) {
			int c = s3.charAt(i);
			if(buf.size() == 0) { 
				return false;
			}
			Set<Pair> newBuf = new HashSet<>();
			buf.forEach(pair -> {
					int s1_idx = n1 - 1 - pair.s1.length();
					int s2_idx = n2 - 1 - pair.s2.length();
					if(s1_idx >= 0 && s1.charAt(s1_idx) == c) {
						newBuf.add(new Pair(s1.substring(s1_idx), pair.s2));
					}
					if(s2_idx >= 0 && s2.charAt(s2_idx) == c) {
						newBuf.add(new Pair(pair.s1, s2.substring(s2_idx)));
					}
				}
			);	
			buf = newBuf;
		} 
		//System.out.println(buf);
		return buf.size() > 0;
	}

	//Represents a pair of strings (s1 and s2).
	class Pair {
		String s1,s2;
		public Pair(String s1, String s2){
			this.s1=s1;
			this.s2=s2;
		}
		@Override
		public String toString() {
			return String.format("%s, %s", s1, s2);
		}
		@Override
		public boolean equals(Object other){
			if(other instanceof Pair){
				Pair o = (Pair)other;
				if(s1.equals(o.s1) && s2.equals(o.s2)) {
					return true;
				}
			}
			return false;
		}
		@Override
		public int hashCode() {
			int result = 5;
			int c1 = s1 == null ? 0 : s1.hashCode();
			result = result*31 + c1;
			int c2 = s2 == null ? 0 : s2.hashCode();
			result = result*31 + c2;
			return result;
		}
	}
}
