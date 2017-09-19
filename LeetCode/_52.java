import java.util.List;
import java.util.ArrayList;

class _52{
	static int[] colPos;
	static int solutionCount = 0;
	public static void main(String args[]) {
		int n = Integer.parseInt(args[0]);
		colPos = new int[n];
		System.out.println(new _52().totalNQueens(n));
	}

	public int totalNQueens(int n) {
		solve(0, n);
		return solutionCount;
	}

	public void solve(int currentRow, int n) {
		for(int col = 0; col < n; col++) {
			if(!hit(currentRow, col)) {
				colPos[currentRow] = col;
				if(currentRow != n-1) {
					solve(currentRow + 1, n);			
				} else {
					solutionCount++;
				}
			}
		} 
	}

	public boolean hit(int row, int col) {
			for(int j = 0; j < row; j++) {
				if(j == row || colPos[j] == col || Math.abs(row - j) == Math.abs(col - colPos[j])) {
					return true;
				}
			}
			return false;
		
	}

}
