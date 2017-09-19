class _87 {
	public static void main(String args[]) {
		System.out.println(new _87().isScramble(args[0], args[1]));
	}	
	public boolean isScramble(String s1, String s2) {
		//System.out.println(s1 + " " + s2);
		int n1 = s1.length();
		int n2 = s2.length();

		//Some quick optimizations
		if(n1 != n2) {
			return false;
		} else if(s1.equalsIgnoreCase(s2)) {
			return true;
		}
		//Base case
		if(n1 == 1) {
			return s1.equalsIgnoreCase(s2);
		}
		
		//Recursive case
		int n = n1;
		int[] buf1 = new int[128];
		int[] buf2 = new int[128];
		String s2rev = new StringBuffer(s2).reverse().toString();

		for(int i = 0; i < n - 1; i++){
			buf1[(int)s1.charAt(i)]++;
			buf1[(int)s2.charAt(i)]--;

			buf2[(int)s1.charAt(i)]++;
			buf2[(int)s2rev.charAt(i)]--;

			if(checkIfAllZeroes(buf1)) {
				if(isScramble(s1.substring(0, i+1), s2.substring(0, i+1)) && isScramble(s1.substring(i+1), s2.substring(i+1))) {
					return true;
				}
			}
			if(checkIfAllZeroes(buf2)){
				return isScramble(s1.substring(0, i+1), s2.substring(n-1-i)) && isScramble(s1.substring(i+1), s2.substring(0, n-1-i));
			}
		}
		return false;
	}

	public boolean checkIfAllZeroes(int[] buf){
		int n =  buf.length;
		for(int i = 0;i < n; i++){
			if(buf[i] != 0) {
				return false;
			}
		}
		return true;
	}
}
