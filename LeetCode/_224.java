class _224{ 
	public int calculate(String s) {
    	char ch[] = s.toCharArray();
    	int i=0;
    	while(i < ch.length){
    		if(ch[i] == '(') {
    			int openCount = 0;
    			while(ch[++i] != ')' || openCount != 0) {
    				if(ch[i] == '(') openCount++;
    			}	
    		}
    	}

    }


}