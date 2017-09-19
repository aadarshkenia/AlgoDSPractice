import java.util.*;
import java.util.stream.*;
class MelodiousPassword {
	private static List<Character> vowels;
	private static List<Character> consonants;

	static{
		vowels = Arrays.asList('a','e','i','o','u');
		consonants = new ArrayList<>();
		for(int i = 97; i <= 122; i++) {			
			char ch = (char)i;
			if(ch != 'y' && !vowels.contains(ch)) {
				consonants.add(ch);
			}
		} 

	}
	public static void main(String args[]) {
		//System.out.println(getAllPasswords(Integer.parseInt(args[0])));
		getAllPasswords(Integer.parseInt(args[0])).forEach(System.out::println);
	}
	
	public static List<String> getAllPasswords(int n) {
		List<String> passwords =  getPasswords('v', n);
		passwords.addAll(getPasswords('c', n));
		return passwords;
	}

	public static List<String> getPasswords(char beginsWith, int n) {
		//Base case
		if(n == 0) {
			return Arrays.asList("");
		}

		char nextCharType = beginsWith == 'c' ? 'v' : 'c';	
		List<Character> current = beginsWith == 'c' ? consonants : vowels;
		return current.stream()
			.flatMap(c -> {
				List<String> subPasswords = getPasswords(nextCharType, n-1);
				return prependCharToStrings(subPasswords, c).stream();
			})
			.collect(Collectors.toList());
	}

	public static List<String> prependCharToStrings(List<String> passwords, char ch) {
		return passwords.stream()
					.map(p -> ch + p)
					.collect(Collectors.toList());
	}


}
