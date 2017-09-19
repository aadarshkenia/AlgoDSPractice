class _137 {
	public static void main(String args[]) {
		int n[] = {1,2,1,1};
		System.out.println("Single number: "+ new _137().singleNumber(n));
	}

	public int singleNumber(int[] nums) {
		int x1 = 0;
		int x2 = 0;
		for(int i : nums) {
			int temp = (x1 & ~x2 & ~i) | (~x1 & x2 & i);
			x2 = (~x1 & ~x2 & i) | (~x1 & x2 & ~i);
			x1 = temp; 
			// System.out.println(x1 + " " + x2);
		}
		return x1 | x2;

    }
}