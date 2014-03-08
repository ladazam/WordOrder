import static org.junit.Assert.*;
import java.util.HashMap;
/**
 * Unit Testing using the latest version of JUnit.
 */

import org.junit.Test;

public class MainTest {
	
	public static void main(String...args){
		
	}

	@Test
	public void test() {
		assertEquals(Main.factorial(3), 6);
	}
	
	@Test
	public void testbc() {
		assertEquals(Main.getRank("bc"), 1);
	}
	
	@Test
	public void testRemoveChar() {
		assertEquals(Main.removeChar("hello", 'h'), "ello");
	}
	
	@Test
	public void testabc() {
		assertEquals(Main.getRank("abc"), 1);
	}
	
	@Test
	public void permutationTest() {
		assertEquals(Main.getPermutations("aabc"), 12);
	}
	
	@Test
	public void permutationTest2() {
		assertEquals(Main.getPermutations("aaa"), 1);
	}
	
	@Test
	public void testabaa() {
		assertEquals(Main.getRank("abaa"), 3);
	}
	
	@Test
	public void duplicatesTest() {
		HashMap<Character, Integer> duplicates = Main.getNumberOfDuplicates("hhhlllello");
		assertEquals(duplicates.get('l'), new Integer(5));
		assertEquals(duplicates.get('h'), new Integer(3));	
	}
	
	@Test
	public void testaabc() {
		assertEquals(Main.getRank("aabc"), 1);
	}
	
	@Test
	public void testabab() {
		assertEquals(Main.getRank("abab"), 2);
	}
	
	@Test
	public void testbaaa() {
		assertEquals(Main.getRank("baaa"), 4);
	}
	
	@Test
	public void testaaabbbc() {
		assertEquals(Main.getRank("aaabcbb"), 3);
	}
	
	@Test
	public void testQuestion() {
		assertEquals(Main.getRank("question"), 24572);
	}
	
	@Test
	public void testBookkeeper() {
		assertEquals(Main.getRank("bookkeeper"), 10743);
	}
	
	@Test
	public void testUpper() {
		assertEquals(Main.getRank("BOOKKEEPER"), 10743);
	}
	
	@Test
	public void substringTest() {
		assertEquals(Main.removeChar("hello", 'h'), "ello");
	}
	
	@Test 
	public void substringTest2() {
		assertEquals(Main.removeChar("hello", 'e'), "hllo");
	}
	
	@Test
	public void substringTest3() {
		System.out.println(Main.removeChar("hello", 'l'));
		assertEquals(Main.removeChar("hello", 'l'), "helo");
	}
	
	@Test
	public void justATest() {
		String inputStr = "ZYXWVUTSRQPONMLKJIHGFEDCB";
		Main.main(inputStr);
	}
	
	@Test
	public void benchmarkTest() {
		long startTime = System.currentTimeMillis();
		Main.getRank("ANTIDISESTABLISHMENTARIANISM");
		long endTime = System.currentTimeMillis();
		System.out.println("Total execution time: " + (endTime - startTime) + " ms");
	}
}
