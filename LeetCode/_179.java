import java.util.*;
import java.util.stream.Collectors;
class _179 {

	public static void main(String args[]) {
		int x[] = {10, 103};
		System.out.println(new _179().largestNumber(x));
	}

	public String largestNumber(int[] nums) {
    	List<Integer> list = Arrays.stream(nums)
      						.boxed()
      						.collect(Collectors.toList());
    	Collections.sort(list, (i1, i2) -> {
    		int i1_copy = i1;
    		int i2_copy = i2;
    		int exp1 = getLargestExponent(i1);
			int exp2 = getLargestExponent(i2);
    		for(int i=1; i <= Math.min(exp1, exp2) ; i++) {
    			int div1 = (int)Math.pow(10.0, (double)(exp1 - i));
    			int div2 = (int)Math.pow(10.0, (double)(exp2 - i));
    			int q1 = i1 / div1;
    			int q2 = i2 / div2;
    			// System.out.println("q1="+q1+" q2="+q2);
    			if(q1 != q2) {
    				return Integer.valueOf(q2).compareTo(Integer.valueOf(q1));
    			}
    			i1 %= div1;
    			i2 %= div2;
    		}
    		if(exp1 == exp2) {
    			return 0;
    		}
    		int smaller = exp1 < exp2 ? i1_copy : i2_copy;
    		int smallerExp = Math.min(exp1, exp2);
    		int larger = exp1 > exp2 ? i1 : i2;
    		int largerCopy = exp1 > exp2 ? i1_copy ? i2_copy;
    		//get msb for smaller num
    		int smaller_msb = smaller / (int)Math.pow(10.0, (double)(smallerExp-1)); 
    		//get first digit of pending last num
    		int larger_rem_msb = larger / (int)Math.pow(10.0, (double)(getLargestExponent(larger)-1));
    		// System.out.println("smaller="+smaller_msb+" larger="+larger_rem_msb);
    		if(smaller_msb < larger_rem_msb) {
    			if(smaller == i1_copy) {
    				return 1;	
    			} else {
    				return -1;
    			}
    		} else if(smaller_msb > larger_rem_msb) {
    			if(smaller == i1_copy) {
    				return -1;	
    			} else {
    				return 1;
    			}
    		} else {
    			return largerCopy;
    		}

    	});
    	System.out.println("Sorted list: " + list);
    	return list.stream().map(n -> n.toString()).collect(Collectors.joining(""));    
    }

    //Get the largest power of 10 that divides the given arg with a quotient of zero.
    private int getLargestExponent(int i) {
    	double exp = 1.0;
    	while(i / (int)Math.pow(10.0, exp) != 0) {
    		exp += 1.0;
    	}
    	return (int) exp;
    }
}