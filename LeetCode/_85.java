//******************************* Based on MorrisChen2008's solution **************************

class _85 {
	public static void main(String args[]) {
		// String[] m = {"0001010","0100000","0101001","0011001","1111110","1001011","0100101","1101110","1010101","1110000"	};
		String[] m1= {"10100","10111","11111","10010"};
		char[][] matrix = new char[m1.length][m1[0].length()];

		for(int i=0; i < m1.length; i++) {
			matrix[i] = m1[i].toCharArray();
		}
		System.out.println(new _85().maximalRectangle(matrix));
	}

	public int maximalRectangle(char[][] matrix) {
		int m = matrix.length;
		if(m == 0) {
			return 0;
		}
		int n = matrix[0].length;
		int[] ht = new int[n];
		int[] left = new int[n];
		int[] right = new int[n];
		fillArr(right, n);

		int maxArea = 0;

		for(int i = 0; i < m; i++) {
			int curLeft = 0, curRight = n-1;
			//Fill up left arr from left to right
			for(int j=0; j < n; j++) {
				if(matrix[i][j] == '0') {
					ht[j] = 0;
					left[j] = 0;
					curLeft = j+1;
				} else {
					ht[j] = ht[j] + 1;
					//For the rectangle of height = ht[j], find the left index
					left[j] = Math.max(left[j], curLeft);
				}
			}

			//Fill up right arr from right to left
			for(int j=n-1; j >=0; j--) {
				if(matrix[i][j] == '0') {
					right[j] = n;
					curRight = j-1;
				} else {
					//For the rectangle of height = ht[j], find the left index
					right[j] = Math.min(right[j], curRight);
				}	

				//Can use the same loop for finding area.
				int area = (right[j] - left[j] + 1) * ht[j];
				if(maxArea < area) {
					maxArea = area;
				}
			}
		}
		return maxArea;			
	}

	private void fillArr(int[] x, int value) {
			for(int i=0; i < x.length; i++) {
				x[i] = value;
			}
	}


}
	

