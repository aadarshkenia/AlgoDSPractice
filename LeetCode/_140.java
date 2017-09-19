import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;	
import java.util.stream.*;
class _140 {
	// static final List<String> emptyList = Collections.<String>emptyList();
	public static void main(String args[]){
		String s = "aaaaa";
		List<String> wordDict = Arrays.asList("a","aa","aaa","aaaa","aaaaa");
		System.out.println(new _140().wordBreak(s, wordDict));
	}


	public List<String> wordBreak(String s, List<String> wordDict) {
		return wordBreak(s, wordDict, new HashMap<String, List<String>>());
    }


    public List<String> wordBreak(String s, List<String> wordDict, Map<String, List<String>> cache) {
    	if(cache.containsKey(s)) {
    		return cache.get(s);
    	} 
    	int n = s.length();
    	List<String> answer = new ArrayList<>();    	
    	for(String word : wordDict) {
    		if(s.startsWith(word)) {
    			if(s.length() == word.length()) {
    				answer.add(word);
    			} else {
	    			String substr = s.substring(word.length());
	    			List<String> sublist = wordBreak(substr, wordDict, cache);
	    			answer.addAll(merge(word, sublist));	
    			}       			 			
    		}
    	}    	
    	//Cache results
    	cache.put(s, answer);
    	return answer;   	    
    }

    public List<String> merge(String word, List<String> wordList) {
    	return wordList.stream()
    			.map(sentence -> {
    				return new StringBuilder(word).append(" ").append(sentence).toString();    				
    			})
    			.collect(Collectors.toList());
    
}
}