import java.util.ArrayList;
import java.util.List;	
import java.util.Arrays;
class _69 {
	static List<Integer> perfectSquares = new ArrayList<>();
	static int perfectSquaresArr[] = null;
	static {
		int i = 1;
		perfectSquares.add(0,0);
		while(i <= Integer.MAX_VALUE/i) {
			perfectSquares.add(i, i * i);
			i++;
		}
		perfectSquaresArr = new int[perfectSquares.size()];
		for(int j=0; j < perfectSquares.size(); j++) {
			perfectSquaresArr[j] = perfectSquares.get(j);
		}
	}


	public int mySqrt(	int x) {
        int ret = Arrays.binarySearch(perfectSquaresArr, x);
		if(ret >= 0) {
			return ret;
		}
		return -ret-2;
	}
	

	public static void main(String args[]) {
		System.out.println(new _69().mySqrt(15));
	}	
}