import java.util.Comparator;
import java.util.PriorityQueue;
class _188 {
	
	public static void main(String args[]) {
		int k=2;
		int prices[] = {1,2,4,2,5,7,2,4,9,0};
		System.out.println(new _188().maxProfit(k, prices));
	}

	public int maxProfit(int k, int[] prices) {
    	int n = prices.length;

    	//Optimization for k >= n/2
    	if(k >= n/2) {
    		int maxProfit = 0;
    		for(int i=1; i < n; i++) {
    			maxProfit = Math.max(0, prices[i] - prices[i-1]);
    		}	
    		return maxProfit;
    	}
    	
		int buf[][] = new int[k+1][n];    			
    	for(int j = 1; j <= k; j++) {
    		int localMax = buf[j-1][n-1] + prices[n-1];
    		for(int i = n-2; i >= 0; i--) {
    			buf[j][i] = Math.max(buf[j][i+1], localMax - prices[i]);
    			localMax = Math.max(localMax, buf[j-1][i] + prices[i]);	
    		}
    		printRow(buf, j);
    		System.out.println();
    	}
    	return buf[k][0];
    }

    private void printRow(int k[][], int row) {
    	for(int i=0; i < k[0].length; i++)
    		System.out.print(k[row][i] + " ");
    }

    
}