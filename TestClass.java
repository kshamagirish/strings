/*
 * Kshama Girish
 * kmg134
 * Programming Project 2
 * Test Class
 */
public class TestClass {
	public static void main(String[] args) {
		
		//Only English Chars - #1
		System.out.println(HW2.onlyEnglishLetters("abDkfdoFRs"));
		System.out.println(HW2.onlyEnglishLetters("lFKe5aaa"));
		
		//Replace every kth char with another char - #2
		System.out.println(HW2.replaceKth('a', 'x', 3, "abcaaa"));
		System.out.println(HW2.replaceKth('a', 'x', 6, "aaaaa"));
		System.out.println(HW2.replaceKth('a', 'x', 0, "aaaaa"));
		
		//Interleave the fist and second string - #3
		System.out.println(HW2.interleave("abcde", "ABC"));
		System.out.println(HW2.interleave("ABC", "abcde"));
		System.out.println(HW2.interleave("abcde", ""));
		System.out.println(HW2.interleave("", "abcde"));
		
		//Blank out the characters in between the words - #4
		System.out.println(HW2.blankWords("This is a Test."));
		System.out.println(HW2.blankWords("Hi."));
		System.out.println(HW2.blankWords(""));
		
		//Every nth word - #5
		System.out.println(HW2.nthWord(3, "zero one    two  three four five six seven"));
		System.out.println(HW2.nthWord(3, "zero"));
		System.out.println(HW2.nthWord(9, "zero one    two  three four five six seven"));
		
		//Truncating the string to the min possible characters - #6
		System.out.println(HW2.truncateAfter(6, "La-te-ly the-re."));
		System.out.println(HW2.truncateAfter(7, "La-te-ly the-re."));
		
		//Truncating the string to the min possible characters - Extra Credit
		System.out.println(HW2.truncateBefore(4, "La-te-ly the-re."));
		System.out.println(HW2.truncateBefore(5, "La-te-ly the-re."));
		System.out.println(HW2.truncateBefore(6, "La-te-ly the-re."));
		System.out.println(HW2.truncateBefore(7, "La-te-ly the-re."));
		
	}
}
