import java.util.HashMap;
import java.util.Arrays;
/*
 * @author Benjamin Liu
 */

public class Main {
	
	public static void main(String...args) {
		/*
		 * Primary driver function, takes args as arguments and prlongs out rank
		 */
		System.out.println("java version: " + System.getProperty("java.runtime.version"));
		try {
			long startTime = System.currentTimeMillis();
			String inputStr = args[0];
			System.out.println("String=" + inputStr + ", Rank: " + getRank(inputStr));
			long endTime = System.currentTimeMillis();
			System.out.println("Total execution time: " + (endTime - startTime) + " ms");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("No argument specified");
		} catch (StringIndexOutOfBoundsException e) {
			System.out.println("Invalid argument given");
		}
	}
	
	public static String getSorted(String original) {
		/*
		 * Gets the sorted version of a string given input string.
		 */
	        char[] chars = original.toCharArray();
	        Arrays.sort(chars);
	        String sorted = new String(chars);
	        return sorted;
	}
	
	static String removeDuplicates(String s) {
		/*
		 * Removes duplicates by copying character by character
		 */
	    StringBuilder noDupes = new StringBuilder();
	    for (int i = 0; i < s.length(); i++) {
	        String si = s.substring(i, i + 1);
	        if (noDupes.indexOf(si) == -1) {
	            noDupes.append(si);
	        }
	    }
	    return noDupes.toString();
	}
	
	public static long factorial(long n) {
		/*
		 * Computes n!.
		 */
		if (n <= 1) {
			return 1;
		} else {
			return n * factorial(n-1);
		}
	}
	
	public static HashMap<Character, Integer> getNumberOfDuplicates(String inString) {
		/*
		 * Returns a hash with a character as the key and an long representing the number of times that character
		 * appears in a string.
		 */
		HashMap<Character, Integer> duplicates = new HashMap<Character, Integer>();
		for(int i = 0; i < inString.length(); i++) {
			Character curChar = inString.charAt(i);
			if (duplicates.get(inString.charAt(i)) == null) {
				duplicates.put(curChar, 1);
			} else {
				duplicates.put(curChar, duplicates.get(curChar) + 1);
			}
		}
		return duplicates;
	}
	
	public static String removeChar(String s, char c) {
		/*
		 * Removes a single character from a string by copying contents longo a stringbuilder.
		 */
		StringBuilder removed = new StringBuilder();
		boolean flag = false;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == c && flag) {
				removed.append(s.charAt(i));
			} else if(s.charAt(i) != c) {
				removed.append(s.charAt(i));
			} else {
				flag = true;
			}
		}
		return removed.toString();
	}
	
	public static long getRank(String inputString) {
		/*
		 * Returns the rank of a string.  i.e. Given QUESTION as an input, returns 27452 indicating the rank of QUESTION in all of its permutations.
		 * Does this calculation recursively by finding the permutations. An example trace would be, given the string BAAA,  I look at the first character
		 * B, and I see that A comes alphabetically before B.  Therefore, I need to examine the strings with A as the head and find the total # of permutations
		 * I have the unique permutation with A as the head to be 3! / 2! which is 3, the 2 comes from the fact that the string with A removed, AAB, has 2 duplicates.
		 * Therefore, I have a total of 3 from this iteration, and I continue on to AAA.  AAA has first letter = A, and since no character is less than A, I will add 0 to the sum and continue to the
		 * final case.  In the base case, I have AA which has the end case of being in alphabetical order, therefore, I add 1 (for subproblems of size 2, alphabetical order will always yield rank 1 and not
		 * AB-order will always yield rank of 2). Therefore, I get 3 + 1 = 4.  Essentially, I am solving subproblems, where BAAA has a subproblem AAA which has a subproblem AA.
		 */
		if (inputString.length() == 2) {
			if (inputString.charAt(0) > inputString.charAt(1)) {
				return 2;
			} else {
				return 1;
			}
		} else {
			Character firstChar = inputString.charAt(0);
			String restOfString = inputString.substring(1);
			String noDupesSorted = getSorted(removeDuplicates(inputString));
			long sum = 0;
			int count = 0;
			while(noDupesSorted.charAt(count) < firstChar && count < noDupesSorted.length()) {
				String removed = removeChar(inputString, noDupesSorted.charAt(count));
				sum += getPermutations(removed);
				count += 1;
			}
			return sum + getRank(restOfString);
		}
	}
	
	public static long getPermutations(String inString) {
		/*
		 * Computes the number of distinct permutations using the formula:
		 *     
		 *       # of permutations = (size of string)! / product((# of duplicates)!).
		 */
		long numerator = factorial(inString.length());
		long denominator = 1;
		HashMap<Character, Integer> duplicates = getNumberOfDuplicates(inString);
		Object[] keys = duplicates.keySet().toArray();
		for(int i = 0; i < keys.length; i++) {
			denominator *= factorial(duplicates.get(keys[i]));
		}
		return numerator / denominator;
	}
}

// QUESTIONFDSAFDSREWQFDTGFD
// String=ZYXWVUTSRQPONMLKJIHGFEDCA, Rank: 7034535277573963776
// String=ZYXWVUTSRQPONMLKJIHGFEDCB, Rank: 7034535277573963776
// 