
class _233{
	public int countDigitOne(int n) {
  		int k = getNumberOfDigits(n);
  		int maxPower = (int)Math.pow(2.0, (double)k);	  	
  		int answer = 0;
  		for(int i = 1; i < maxPower; i++) {
  			String binary = Integer.toBinaryString(i);
  			answer += countPossibleNumbers(binary.toCharArray(), n);

  		}	  	
	}

	private int getNumberOfDigits(int n) {
		int i=1;
		while(n/(Math.pow(10.0, (double)i)) != 0){
			i++;
		}
		return i;
	}

	//Count the num of possible integers that have 1's in the positions
	//represented by ones in the character array.
	private int countPossibleNumbers(char[] binary, int n) {
		int numOnes = oneCount(binary);		
		int n = binary.length, ans = 0;
		for(int i=0; i < n; i++){
			ans += 
		}
	}

	private int oneCount(char c[]) {
		int count = 0;
		for(int i=0; i < c.length; i++){
			if(c[i] == '1')
				count++;
		}
		return count;
	}
}