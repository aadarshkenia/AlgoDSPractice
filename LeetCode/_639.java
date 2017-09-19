import java.util.Arrays;
class _639 {
	public static void main(String args[]) {
		String s = "2*";
		System.out.println(new _639().numDecodings(s));
	}
	static final long MOD = 1000000009;
	public int numDecodings(String s) {
    	
    	int n = s.length();
     	int ways[] = new int[n+1];     	
     	for(int i = 0; i < n; i++) {
     		long temp = 0;
     		if(i > 0) {
     			char prev = s.charAt(i-1);
     			char current = s.charAt(i);
     			int mult = getMultiplier(prev, current);
     			int prevCount = i == 1 ? 1 : ways[i-1];
     			System.out.println(String.format("multiplier=%d prevCount=%d", mult, prevCount));
     			temp += mult * prevCount;
     		}
     		if(s.charAt(i) != '0') {
     			int prevCount = i == 0 ? 1 : ways[i];
     			if(s.charAt(i) == '*') {
     				temp += 9 * prevCount;//THIS MAYBE WRONG && MOD ANS BEFORE STORING
     			} else {
     				temp += prevCount;	
     			}     			
     		}
            
     		ways[i+1] = (int)(temp % MOD);
     	}   
        System.out.println(Arrays.toString(ways));
     	return ways[n];    
    }

    private int getMultiplier(char c1, char c2) {
    	if(c1 == '0') {
    		return 0;
    	}
    	if(c1 == '*' && c2 == '*') {
    		return 15;	
    	} else if(c1 == '*') {
            int c2_int = Integer.parseInt("" + c2); 
    		if(c2_int >= 0 && c2_int <= 6) {
    			return 2;
    		} else {
    			return 1;
    		}
    	} else if(c2 == '*') {
    		if(c1 == '1'){
    			return 9;
    		} else if(c1 == '2') {
    			return 6;
    		} else {
    			return 0;
    		}
    	} else {
    		int i = Integer.parseInt(c1+ "" + c2);
    		if(i>=1 && i<=26)
    			return 1;
    		else
    			return 0;
    	}
    }
}