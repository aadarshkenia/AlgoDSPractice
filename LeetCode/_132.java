import java.util.Map;
import java.util.HashMap;
class _132 {
	static String str;
	public static void main(String args[]) {
		int ans = new _132().minCut(args[0]);
		System.out.println("min cuts = " + ans);
	}

	public int minCut(String s) {
		int n = s.length();
		char c[]  = s.toCharArray();
		int minCuts[] = new int[n];
		boolean isPalin[][] = new boolean[n][n];

		for(int start = n-1; start >= 0; start--) {
			int min = Integer.MAX_VALUE;
			for(int end = start; end < n; end++) {
				if(c[start] == c[end] && ((start+1 >= end-1) || isPalin[start+1][end-1])) {
					if(end != n-1) {
						min = Math.min(minCuts[end + 1] + 1, min);
					} else {
						// System.out.println(String.format("start=%d end=%d",start,end));
						min = 0;
					}
					isPalin[start][end] = true;
				}
			}//inner for
			// System.out.println(String.format("minCuts[%d]=%d", start,min));
			minCuts[start] = min;
		}//outer for
		return minCuts[0];
	}

}
