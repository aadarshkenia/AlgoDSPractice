import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class _135 {
	public static void main(String args[]) throws IOException{
		//Take space separated nums as input
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter n:");
		int n = Integer.parseInt(br.readLine());
		int r[] = new int[n];
		System.out.println("Enter ratings as space separated integers:");
		String ratings = br.readLine();
		String[] ratings_str = ratings.split("\\s+");
		for(int i=0; i < ratings_str.length; i++) {
			r[i] = Integer.parseInt(ratings_str[i]);
		}
		System.out.println("\nMin Candies: " + new _135().candy(r));
	}

	public int candy(int[] ratings) {
		int minCandies = 0;
		int n = ratings.length, i = 0, start = 0, prevMin = 0;
		while(i < n) {
			if(i != n-1 && ratings[i] > ratings[i+1]) {
				i++;
			} else {
				int numElems = i - start + 1; 
				if(numElems == 1) {  //if only 1 elem i.e i==satrt
					if(i != 0 && ratings[i] > ratings[i-1]) {
						prevMin += 1;
					} else {
						prevMin = 1;
					}
					minCandies += prevMin;						
				}
				else {
					int incr = (numElems * (numElems + 1)) / 2;
					minCandies += (numElems * (numElems + 1)) / 2;
					if(start != 0 && ratings[start] > ratings[start-1] && numElems <= prevMin) {
						minCandies += (prevMin - numElems + 1);
					}
					prevMin = 1;
				}
				start = i + 1;	
				i = start;
			}
		}	
		return minCandies;
	}

	
}
