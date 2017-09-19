import java.util.List;
import java.util.ArrayList;

class _51{
	static int[] colPos;
	public static void main(String args[]) {
		int n = Integer.parseInt(args[0]);
		colPos = new int[n];
		System.out.println(new _51().solveNQueens(n));
	}

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> answers = new ArrayList<>();
		solve(0, n, answers);
		return answers;
	}

	public void solve(int currentRow, int n, List<List<String>> answers) {
		for(int col = 0; col < n; col++) {
			if(!hit(currentRow, col)) {
				colPos[currentRow] = col;
				if(currentRow != n-1) {
					solve(currentRow + 1, n, answers);			
				} else {
					answers.add(getAnswer(colPos));
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

	public List<String> getAnswer(int[] colPos) {
		List<String> ans = new ArrayList<>();
		int n = colPos.length;
		for(int i = 0; i < n; i++) {
			int column = colPos[i];
			StringBuffer sb = new StringBuffer();
			for(int j=0; j < n; j++) {
				char ch = j == column ? 'Q' : '.';
				sb.append(ch);
			}
			ans.add(i, sb.toString());
		}
		return ans;
	}
}
