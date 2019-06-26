
/*
 * Kshama Girish
 * kmg134
 * Programming Project 2
 * List of methods
 */
public class HW2 {
	/*
	 * #1- It iterates through the entire string checking each character if it is an English string.
	 * if it is, it instantly returns false. eElse it returns true.
	 */
	public static boolean onlyEnglishLetters(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(!Character.isLetter(s.charAt(i))) {
				return false; 
			}
		}
		return true; 
	}
	/*
	 * #2- We keep track of how many times char a has appeared. it if equals the count c, the next appearance is replaced by char b. 
	 */
	public static String replaceKth(char a, char b, int c, String s) { 
		StringBuilder s2 = new StringBuilder("");
		int counter = 1; // keeps track of how many times a has appeared
		for(int i = 0; i < s.length(); i++) {
			char add; // Char appended to the StringBuilder at the end
			if(s.charAt(i) == a) {
				if(counter == c) {
					// Case where a has appeared c times
					add = b;
					counter = 1;
				} else {
					//Case where a has yet to appear c times
					add = a;
					counter++;
				}
			} else {
				//Case where the current char is not a
				add = s.charAt(i);
			}
			s2.append(add);
		}
		return s2.toString(); 
	}
	/*
	 * #3- First, the minimum length of the two strings is found. 
	 *     Then each string is iterated up to the minimum length with alternative characters.
	 *     Then the longer string is iterated to completion. 
	 */
	public static String interleave(String a, String b) {
		StringBuilder sb = new StringBuilder();
		int minLength; 
		
		//Checks for the minimum length of the two strings and sets it accordingly
		if(a.length() > b.length()) {
			minLength = b.length();
		} else {
			minLength = a.length();
		}
		//Iterates both strings to minLength
		for(int i = 0; i < minLength; i++) {
			sb.append(a.charAt(i));
			sb.append(b.charAt(i));
		}
		
		//Iterates the larger string to the end. The smaller string will never begin iteration.
		for (int i = minLength; i < a.length(); i++){
		    sb.append(a.charAt(i));
		}

		for (int i = minLength; i < b.length(); i++){
		    sb.append(b.charAt(i));
		}
		return sb.toString(); 
	}
	/*
	 * #4- First we assert that the current character is a letter
	 *     Then we check the cases where we are either at 
	 *          the beginning or end of the string, 
	 *          in the middle of a word, 
	 *          or at the beginning or end of a string 
	 *     and handle them accordingly.
	 *     The output is any word longer than two characters has its' internal letters replaced with underscores
	 */
	public static String blankWords(String s) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i))) {
				//Case where we are at some point in a word
				if(i - 1 < 0 || i + 1 >= s.length()) {
					//Case where we are at the beginning or end of the string
					sb.append(s.charAt(i));
				} else if(Character.isLetter(s.charAt(i-1)) && Character.isLetter(s.charAt(i+1))) {
					//Case where we are between a string
					sb.append('_'); //replacing with "_"
				} else {
					//Case where we are at the beginning or end of a word.
					sb.append(s.charAt(i));
				}
			} else {
				//Case where we are at some blank space in the middle
				sb.append(s.charAt(i));
			}
		}
		return sb.toString();
	}
	/*
	 * #5- We keep track of whether a word was started and ended and set a boolean flag to manage it. 
	 *     If a word is found, then it checks if it is the ath word found and adds its accordingly
	 *     The output is a string where only the ath word appears.
	 */    
	public static String nthWord(int a, String s) {
		StringBuilder sb = new StringBuilder();
		StringBuilder word = new StringBuilder(); // StringBuilder which holds the current word
		boolean wordFound = false, isWord = false; //booleans which keep check of whether we have found the beginning of a word 
		int wordCount = 0;
		int endOfLine = s.length() - 1;
		for(int i = 0; i < s.length(); i++) {
			if(Character.isLetter(s.charAt(i)) && i != endOfLine) {
				//Case where we are at the beginning of a word and not at the end of the string
				isWord = true;
				word.append(s.charAt(i));
			} else if(!Character.isLetter(s.charAt(i)) && isWord) {
				//Case where we are at the end of a word and the isWord flag was set off before. 
				isWord = false;
				wordCount++;
				wordFound = true;
			} else if(Character.isLetter(s.charAt(i)) && i == endOfLine) {
				//Case where we are at the end of the string
				wordCount++;
				word.append(s.charAt(i));
				wordFound = true;
			}
			//Handles whether a word is found
			if(wordFound) {
				if(wordCount == 1 || wordCount % a-1 == 0) {
					//Case where this is the ath word and it should be appended to the final string.
					wordFound = false;
					sb.append(word.toString() + " ");
					word = new StringBuilder();
				} else {
					//Case where we are not at the ath word and it just resets the proper variables
					word = new StringBuilder();
					wordFound = false;
				}
			}
		}
		sb.deleteCharAt(sb.length()-1);
		return sb.toString();
	}
	/*
	 * #6 - We iterate through string s and add letters until we hit the max a
	 *      then we check if we are at a safe truncation point and if we are then the string is returned. else we continue until we hit a safe truncation point
	 *      the output is the string properly truncated to the minimum letters.
	 */
	public static String truncateAfter(int a, String s) {
		StringBuilder sb = new StringBuilder();
		int charCount = 0;
		int index = 0;
		for(int i = 0; charCount < a; i++) {
			//Iterate to the minimum number of characters
			if(Character.isLetter(s.charAt(i))) {
				sb.append(s.charAt(i));
				charCount++;
			} else if(s.charAt(i) == ' ') {
				sb.append(' ');
				
			}
			index = i;
		}
		sb.deleteCharAt(index-2);
		//iterate until we are at a safe truncation point. 
		for(int j = index; j < s.length(); j++) {
			if(s.charAt(j) == '-' || s.charAt(j) == ' ') {
				sb.append(s.charAt(j));
				j = s.length() + 1;
			} else {
				sb.append(s.charAt(j));
			}
		}
		return sb.toString();
	}
	
	/*
	 * Extra Credit - 
	 *     iterate through a string up to the max characters a
	 *     then check whether we are at a full word, safe truncation point or random point and handles it accordingly
	 *     full word or truncation points are just returned.
	 *     else the string is iterated in reverse until a safe truncation point is hit
	 *     the result is a string with the max number of letters truncated at the safest point. 
	 *   
	 */
	public static String truncateBefore(int a, String s) { 
		StringBuilder sb = new StringBuilder();
		int charCount = 0;
		int charCountWithSpaces = 0;
		int index = 0;
		for(int  i = 0; charCount < a; i++) {
			//Iterate the string to the max letters
			if(Character.isLetter(s.charAt(i))) {
				charCount++;
				charCountWithSpaces++;
				sb.append(s.charAt(i));
			} else if(s.charAt(i) == ' ') {
				sb.append(' ');
				charCountWithSpaces++;
			}
			index = i;
		}
		if(s.charAt(index+1) == ' ') {
			//Case where we are at the end of a word
			return sb.toString();
		} else if(s.charAt(index+1) == '-') {
			//Case where we are at a safe truncation point
			sb.append('-');
			return sb.toString();
		}  else {
			//Case where we need to cut off characters in reverse
			for(int i = index; i != 0; i--) {
				if(s.charAt(i) == '-' || s.charAt(i) == ' ') {
					sb.append(s.charAt(i));
					i = 1;
				}  else {
					sb.deleteCharAt(charCountWithSpaces-1);
					charCountWithSpaces--;
				}
			}
		}
		return sb.toString();
	}
	
}
