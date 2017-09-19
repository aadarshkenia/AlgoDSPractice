import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
class _152 {
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the array as space separated integers");
		String s[] = br.readLine().split("\\s+");
		int x[] = new int[s.length];
		for(int i=0; i < s.length;i++) {
			x[i] = Integer.parseInt(s[i]);
		}

		System.out.println("Max product:" + new _152().maxProduct(x));
	}

	public int maxProduct(int[] nums) {
		/***
		 t2 denotes the product of sequence starting after the first negative number.
		**/
     	int t1=1, t2 =1, maxVal = nums[0], numNeg = 0;
     	for(int i = 0; i < nums.length; i++) {
     		if(nums[i] == 0) {     			
     			numNeg = 0; t1 = 1; t2 = 1;
     			if(maxVal < 0)
     				maxVal = 0;
     		} else if(nums[i] > 0) {
     			t1 *= nums[i];
     			t2 *= nums[i];
     			maxVal = max(t1, t2, maxVal);
     		} else {
     			numNeg++;
     			if(numNeg == 1) {
     				t1 *= nums[i];
     				maxVal = Math.max(maxVal, t1);
     				t2 = 1;
     			} else {
     				t1 *= nums[i];
     				t2 *= nums[i];
     				maxVal = max(t1, t2, maxVal); 
     			}
     		}
     	}   
    	return  maxVal;
    }

    private int max(int a, int b, int c) {
    	return Math.max(a,Math.max(b,c));
    }
}