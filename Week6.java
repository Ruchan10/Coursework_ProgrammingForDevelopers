package CourseWork;

// Java program for the above approach
import java.io.*;
import java.util.*;

class Week6 {
	// checking if digits can be assigned to characters
	public static boolean isSolvable(String[] words,String result)
	{
		// Stores the value
		// assigned to alphabets
		int mp[] = new int[26];
		// stores number assigned to characters
		int used[] = new int[10];

		int Hash[] = new int[26];

		int CharAtfront[] = new int[26];

		Arrays.fill(mp, -1);
		Arrays.fill(used, 0);
		Arrays.fill(Hash, 0);
		Arrays.fill(CharAtfront, 0);

		// stores the string created after adding two characters
		StringBuilder uniq = new StringBuilder();

		// iterating over the strings
		for (String word : words) {
			// looping over the word
			for (int i = 0; i < word.length(); i++) {

				// stores the character at a position
				char ch = word.charAt(i);

				Hash[ch - 'A'] += (int)Math.pow(
					10, word.length() - i - 1);

				if (mp[ch - 'A'] == -1) {

					mp[ch - 'A'] = 0;
					uniq.append((char)ch);
				}


				// if i is 0 and word.length is greater than 1
				if (i == 0 && word.length() > 1) {

					CharAtfront[ch - 'A'] = 1;
				}
			}
		}

		// Iterate over result
		for (int i = 0; i < result.length(); i++) {

			char ch = result.charAt(i);

			Hash[ch - 'A'] -= (int)Math.pow(
				10, result.length() - i - 1);

			if (mp[ch - 'A'] == -1) {
				mp[ch - 'A'] = 0;
				uniq.append((char)ch);
			}

			// If i is 0 and length of result is greater than 1
			if (i == 0 && result.length() > 1) {
				CharAtfront[ch - 'A'] = 1;
			}
		}

		Arrays.fill(mp, -1);

		// Recursive call of the function
		return solve(uniq, 0, 0, mp, used, Hash,
					CharAtfront);
	}

	public static boolean solve(
		StringBuilder words, int i,
		int S, int[] mp, int[] used,
		int[] Hash,
		int[] CharAtfront)
	{
		// If i is word.length
		if (i == words.length())

			return (S == 0);

		// store the character
		char ch = words.charAt(i);

		// Stores the value of ch
		int val = mp[words.charAt(i) - 'A'];

		if (val != -1) {

			// call recursion if val is not -1
			return solve(words, i + 1,
						S + val * Hash[ch - 'A'],
						mp, used,
						Hash, CharAtfront);
		}

		boolean x = false;

		// Iterate over the range
		for (int l = 0; l < 10; l++) {

			if (CharAtfront[ch - 'A'] == 1
				&& l == 0)
				continue;

			// If used[l] is true
			if (used[l] == 1)
				continue;

			// Assign l to ch
			mp[ch - 'A'] = l;

			// Marked l as visited
			used[l] = 1;

			// Recursive function call
			x |= solve(words, i + 1,
					S + l * Hash[ch - 'A'],
					mp, used, Hash, CharAtfront);

			mp[ch - 'A'] = -1;

			used[l] = 0;
		}

		// Return the value of x;
		return x;
	}

	public static void main(String[] args)
	{
		String[] arr
			= { "THIS", "IS", "TOO" };
		String S = "FUNNY";

		if (isSolvable(arr, S))
			System.out.println("Yes");
		else
			System.out.println("No");
	}
}
