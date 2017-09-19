import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
class _616 {
	private static final String BOLD_START = "<b>";
	private static final String BOLD_END = "</b>";
	public static void main(String args[]) {
		String s = "abcdef";
		String dict[] = {"a", "c", "e", "g"};
		System.out.println(new _616().addBoldTag(s, dict));
	}

	public String addBoldTag(String s, String[] dict) {
		int n = s.length();
		List<Pos> positions = new ArrayList<>(n);
		/*for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				String substr = s.substring(i, j + 1);
				if(words.contains(substr)) {
					positions.add(new Pos(i, j));
				}
			}			
		}    */
		for(String word : dict) {
			KMPSearch(word, s, positions);
		}

		int[] hash = new int[n];
		for(Pos pos: positions) {
			for(int i = pos.start; i <= pos.end; i++) {
				hash[i] = 1;
			}
		}
		for(int i=0; i < n;i++)	System.out.println(hash[i] + " ");

		StringBuilder ans = new StringBuilder();
		int boldStart =0 ,boldEnd = 0;
		for(int i=0; i < n; i++){
			if(hash[i] == 1) {
				 if(i == 0 || hash[i-1] == 0) {
				 	boldStart = i;
				 }

				 if(i == n-1 || hash[i+1] == 0) {
				 	boldEnd = i;
				 	ans.append(BOLD_START + s.substring(boldStart, boldEnd + 1) + BOLD_END);
				 }
				 

			} else {
				ans.append(s.charAt(i));
			} 
		}
		return ans.toString();	
    }

    //KMP Search algo from GFG
    private void KMPSearch(String pat, String txt, List<Pos> positions)
    {

        int M = pat.length();
        int N = txt.length();
 
        // create lps[] that will hold the longest
        // prefix suffix values for pattern
        int lps[] = new int[M];
        int j = 0;  // index for pat[]
 
        // Preprocess the pattern (calculate lps[]
        // array)
        computeLPSArray(pat,M,lps);
 
        int i = 0;  // index for txt[]
        while (i < N)
        {
            if (pat.charAt(j) == txt.charAt(i))
            {
                j++;
                i++;
            }
            if (j == M)
            {
                // System.out.println("Found pattern "+
                              // "at index " + (i-j));
                positions.add(new Pos(i-j, i - j + M - 1));
                j = lps[j-1];
            }
 
            // mismatch after j matches
            else if (i < N && pat.charAt(j) != txt.charAt(i))
            {
                // Do not match lps[0..lps[j-1]] characters,
                // they will match anyway
                if (j != 0)
                    j = lps[j-1];
                else
                    i = i+1;
            }
        }
    }

    private void computeLPSArray(String pat, int M, int lps[])
    {
        // length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        lps[0] = 0;  // lps[0] is always 0
 
        // the loop calculates lps[i] for i = 1 to M-1
        while (i < M)
        {
            if (pat.charAt(i) == pat.charAt(len))
            {
                len++;
                lps[i] = len;
                i++;
            }
            else  // (pat[i] != pat[len])
            {
                // This is tricky. Consider the example.
                // AAACAAAA and i = 7. The idea is similar 
                // to search step.
                if (len != 0)
                {
                    len = lps[len-1];
 
                    // Also, note that we do not increment
                    // i here
                }
                else  // if (len == 0)
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    private static class Pos{
    	int start;
    	int end;
    	Pos(int start, int end) {
    		this.start = start;
    		this.end = end;
    	}
    }
}