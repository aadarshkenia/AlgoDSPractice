import java.util.Arrays;
class _4 {
	public static void main(String args[]) {
		int nums1[] = {1,4,5,6,10};
		int nums2[] = {2,3,9,11,12,13};
		System.out.println(new _4().findMedianSortedArrays(nums1, nums2));
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
   		int m = nums1.length, n = nums2.length;
		int l1 = 0, h1 = m-1;
		int l2 = 0, h2 = n-1;
		int totalSize = m + n;
		while(totalSize < 5) {
			System.out.println(String.format("(%d, %d)   (%d, %d)", l1, h1, l2, h2));
			int mid1 = l1 + (h1 - l1)/2;
			int mid2 = l2 + (h2 - l2)/2;
			if(nums1[mid1] < nums2[mid2]) {
				int numLeft = h1 - mid1 + 1; //Number of left array elems in next iteration
				int numRight = mid2 - l2 + 1; //Number of right array elems in next iteration

				if(totalSize % 2 == 0) {
					if(numLeft != numRight){
						//Discard either mid1 or mid2
						if(numLeft > numRight) {
							mid1++;
						} else {
							mid2--;
						}
					}
				} else {
					if(numLeft == numRight) {
						//Discard either mid1 or mid2
						
					}
				}

				if(n - numLeft - numRight != subN) {
					int bal = subTotal - numLeft - numRight - subN;
					System.out.println("Bal: " + bal);
					if(numLeft < numRight) {
						mid1++;
					} else {
						mid2--;
					}	
				}
				l1 = mid1; h2 = mid2;

			} else {
				int numLeft = mid2 - l2; //Smallest elems
				int numRight = h1 - mid1; //Largest elems
				if(subTotal - numLeft - numRight != subN) {
					int bal = subTotal - numLeft - numRight - subN;
					System.out.println("Bal: " + bal);
					if(numLeft < numRight) {
						mid2--;
					} else {
						mid1++;
					}	
				}
				h1 = mid1; l2 = mid2;
					
			}
		}

		return findMedian(baseLen, l1, h1, l2, h2, nums1, nums2);


	}
	//returns the total number of elems in next iteration of loop, given the num of elems in current iteration
	private int subArrTotalLength(int n){
		int sub = n / 2;
		if(n % 2 == 0) {
			return sub % 2 == 0 ? sub : sub + 1;
		} else {
			return sub % 2 == 1 ? sub : sub + 1;
		}
		
	}

	private double findMedian(int total, int l1, int h1, int l2, int h2, int[] nums1, int[] nums2) {
		System.out.println(String.format("(%d, %d)   (%d, %d)", l1, h1, l2, h2));
		int arr[] = new int[total];
		int ctr = 0;
		for(int i=l1; i <= h1; i++){
			arr[ctr++] = nums1[i];
		}
		for(int i=l2; i <= h2; i++){
			arr[ctr++] = nums2[i];
		}
		printArr(arr);
		Arrays.sort(arr);
		printArr(arr);
		if(total == 4) {
			return (arr[1] + arr[2]) / 2.0; 
		} else {
			return (double)arr[1];
		}
	}

	private void printArr(int[] x) {
		for(int i=0 ; i < x.length; i++){
			System.out.print(x[i]+ " "); 
		}
		System.out.println();
	}
}
