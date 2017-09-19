class _165 {

	public static void main(String args[]) {
		System.out.println(new _165().compareVersion(args[0], args[1]));
	}

	public int compareVersion(String version1, String version2) {
        String s1[] = version1.split("\\.");
        String s2[] = version2.split("\\.");
        int min = Math.min(s1.length, s2.length);
        for(int i=0; i < min; i++) {
        	Integer i1 = Integer.parseInt(s1[i]);
        	Integer i2 = Integer.parseInt(s2[i]);
        	System.out.println(i1.intValue());
        	System.out.println(i2.intValue());
        	if(!i1.equals(i2)) {
        		return i1.compareTo(i2);
        	} 
        	if(i == min-1) {
        		if(s1.length > s2.length) {
        			if(checkIfAllZeroes(min, s1)) {
        				return 0;
        			}
        			return 1;
        		} else if(s2.length > s1.length) {
        			if(checkIfAllZeroes(min, s2)) {
        				return 0;
        			}
        			return -1;
        		}
        	}
        }
        return 0;   
    }

    private boolean checkIfAllZeroes(int start, String arr[]) {
    	for(int i=start; i < arr.length; i++) {
    		if(Integer.parseInt(arr[i]) != 0) {
    			return false;
    		}
    	}
    	return true;
    }
}