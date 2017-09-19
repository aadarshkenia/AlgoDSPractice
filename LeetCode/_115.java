class _115 {
	public static void main(String args[]) {
		String s = args[0];
		String t = args[1];
		System.out.println(new _115().numDistinct(s, t));
	}

	public int numDistinct(String s, String t){
		int n = s.length();
		int m = t.length();
		if(m > n) {
			return 0;
		}
		int buf[][] = new int[m+1][n+1];
		//Fill first row
		for(int i = 0; i <= n; i++) {
			buf[0][i] = 1;
		}

		for(int i = 1; i <= m; i++) {
			char t_char = t.charAt(i-1);
			for(int j = 1; j <= n;j++) {
				char s_char = s.charAt(j-1);
				if(t_char == s_char) {
					buf[i][j] = buf[i-1][j-1] + buf[i][j-1];
				} else {
					buf[i][j] = buf[i][j-1];				
				}
			}
		}
		return buf[m][n]
	;}
}
