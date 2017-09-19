class _38 {
	public static void main(String args[]) {		
		if(args.length < 1) {
			System.out.println("Enter the value of n as command line arg.");
		} else {
			System.out.println(new _38().countAndSay(Integer.parseInt(args[0])));				
		}
	}

	public String countAndSay(int n) {
		String firstTerm = "1";
		if(n == 1) {
			return firstTerm;
		}
		String prevTerm = firstTerm;
		for(int i = 2; i <= n; i++) {
			String nextTerm = getNextTerm(prevTerm);
			System.out.println("Term " + i + " : " + nextTerm);
			prevTerm = nextTerm;
		}
		return prevTerm;

	}
	
	private String getNextTerm(String prevTerm) {
		char prev[] = prevTerm.toCharArray();
		StringBuffer ans = new StringBuffer();
		int index = 0;
		char currentChar = prev[0];
		int freq = 0;
		while(index < prev.length) {
			if(prev[index] == currentChar) {
				freq++;
				index++;
			} else {
				ans.append(freq);
				ans.append(currentChar);
				currentChar = prev[index];
				freq = 0;
			}
		}
		ans.append(freq);
		ans.append(currentChar);
		return ans.toString();
		
	}

}
