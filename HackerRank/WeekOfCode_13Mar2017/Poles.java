class Poles {
	public static void main(String args[]){ 
		int n=6, k=2;
		int h[] = {10, 12, 16, 18, 30, 32};
		int w[] = {15, 17, 18, 13, 10, 1};
		System.out.println(getMinCost(n, k, w, h));
	}

	public static int getMinCost(int n, int k, int[] w, int[] h) {
		int buf[][] = new int[k][n];
		int cumulativeWeights[] = new int[n];
		cumulativeWeights[0] = w[0];
		//Fill up first row
		for(int i = 1; i < n; i++) {
			buf[0][i] = buf[0][i-1] + (h[i] - h[0]) * w[i]; 	
			cumulativeWeights[i] = cumulativeWeights[i-1] + w[i];
		}

		for(int j = 1; j < k; j++) { 
			for(int i = j+1; i < n; i++) {
				int min = Integer.MAX_VALUE, index = 0, sum = 0;
				for(int temp = i; temp >= j; temp--) {
					int hdiff = temp != i ? h[temp+1] - h[temp] : 0;
					int cumWeightOfNumTerms = cumulativeWeights[i] - cumulativeWeights[temp];
					sum += hdiff * cumWeightOfNumTerms;
					System.out.println("temp= " + temp + "sum= " + sum);
					if(buf[j-1][temp-1] + sum < min) {
						min = buf[j-1][temp-1] + sum;
						index = temp;
					}
				}
				buf[j][i] = min;
				System.out.println("min: " + min + " stackPos: " + index);
			}
		}
		printArr(buf, k, n);
		return buf[k-1][n-1];
	}

	private static void printArr(int a[][], int rows, int cols){
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				System.out.print(a[i][j]+ " ");
			}
			System.out.println();
		}
	}
}
