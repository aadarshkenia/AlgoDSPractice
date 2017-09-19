import java.util.Stack;
class _150 {
	
	public static void main(String args[]) {
		String tokens[] = {"1", "2", "+", "1", "/"};
		System.out.println(new _150().evalRPN(tokens));
	}

	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<>();		
		for(int i=0 ; i < tokens.length; i++) {
			String s = tokens[i];
			if(isOperator(s)) {
				int op2 = stack.pop();
				int op1 = stack.pop();
				int res = operate(s, op1, op2);
				stack.push(res);
			} else {
				stack.push(Integer.parseInt(s));
			}
		}
		return stack.pop();	        
    }

    private boolean isOperator(String s) {
    	return s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/");
    }

    private int operate(String s, int op1, int op2) {
    	switch(s) {
    		case "+":
    			return op1 + op2;
    		case "-":
    			return op1 - op2;
    		case "*":
    			return op1 * op2;	
    		case "/":
    			return op1 / op2;
    	}
    	throw new RuntimeException("Invalid operator: " + s);
    }

}