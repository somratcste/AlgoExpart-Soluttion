package string;

public class ReverseWordsInString {
    // solution 1
    /*
    // O(n) time | O(n) space
  public String reverseWordsInString(String string) {
		ArrayList<String> words = new ArrayList<String>();
		int startOfWord = 0;

		for (int idx = 0; idx < string.length(); idx++) {
			char character = string.charAt(idx);

			if (character == ' ') {
				words.add(string.substring(startOfWord, idx));
				startOfWord = idx;
			} else if (string.charAt(startOfWord) == ' ') {
				words.add(" ");
				startOfWord = idx;
			}
		}

		words.add(string.substring(startOfWord));
		Collections.reverse(words);
    return String.join("", words);
  }
     */

    // solution 2
    // O(n) time | O(n) space
    public String reverseWordsInString(String string) {
        char[] characters = string.toCharArray();
        reverseListRange(characters, 0, characters.length - 1);

        int startOfWord = 0;
        while (startOfWord < characters.length) {
            int endOfWord = startOfWord;
            while (endOfWord < characters.length && characters[endOfWord] != ' ') {
                endOfWord += 1;
            }

            reverseListRange(characters, startOfWord, endOfWord-1);
            startOfWord = endOfWord + 1;
        }

        return new String(characters);
    }

    public char[] reverseListRange(char[] list, int start, int end) {
        while (start < end) {
            char temp = list[start];
            list[start] = list[end];
            list[end] = temp;
            start += 1;
            end -= 1;
        }
        return list;
    }
}
