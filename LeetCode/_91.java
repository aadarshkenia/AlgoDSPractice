class _91 {
	public int numDecodings(String s) {
     	int n = s.length();
        if(n == 0) {
            return 0;
        }
     	int ways[] = new int[n+1];
        ways[1] = s.charAt(0) == '0' ? 0 : 1;
     	for(int i = 1; i < n; i++) {
     		int temp = 0;
     		if(i > 0) {
     			int lastTwo = Integer.parseInt(s.substring(i - 1, i + 1));
     			if(s.charAt(i-1) != '0' && lastTwo >= 1 && lastTwo <= 26){
     				if(i == 1) {
     					temp = 1;
     				} else {
     					temp = ways[i-1];
     				}
     			}
     		}
     		if(s.charAt(i) != '0') {
     			temp += ways[i];
     		}
     		ways[i+1] = temp;
     	}   
     	return ways[n];
    }
}