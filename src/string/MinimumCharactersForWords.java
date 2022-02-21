package string;

import java.util.*;

// O(n*l) time | O(c) space - where n is the number of words
// l is the length of the longest word, and c is the unique number of
// characters across the all words
public class MinimumCharactersForWords {
    public char[] minimumCharactersForWords(String[] words) {
        // Write your code here.
        HashMap<Character, Integer> maximumCharacterFreq = new HashMap<Character, Integer>();
        for (String word: words) {
            HashMap<Character, Integer> chracterFrequencies = countCharacterFreq(word);
            updateMaximumFreq(chracterFrequencies, maximumCharacterFreq);
        }
        return myArrayFromCharacterFreq(maximumCharacterFreq);
    }

    public HashMap<Character, Integer> countCharacterFreq(String string) {
        HashMap<Character, Integer> characterFrequencies = new HashMap<Character, Integer>();

        for (char character: string.toCharArray()) {
            characterFrequencies.put(character, characterFrequencies.getOrDefault(character, 0) + 1);
        }

        return characterFrequencies;
    }

    public void updateMaximumFreq(HashMap<Character, Integer> frequencies,
                                  HashMap<Character, Integer> maximumFrequencies) {
        for (Map.Entry<Character, Integer> frequency: frequencies.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            if (maximumFrequencies.containsKey(character)) {
                maximumFrequencies.put(character, Math.max(characterFrequency, maximumFrequencies.get(character)));
            } else {
                maximumFrequencies.put(character, characterFrequency);
            }
        }
    }

    public char[] myArrayFromCharacterFreq(HashMap<Character, Integer> characterFreq) {
        ArrayList<Character> characters = new ArrayList<Character>();

        for (Map.Entry<Character, Integer> frequency: characterFreq.entrySet()) {
            char character = frequency.getKey();
            int characterFrequency = frequency.getValue();

            for (int count = 0; count < characterFrequency; count++) {
                characters.add(character);
            }
        }

        char[] charactersArray = new char[characters.size()];
        for (int count = 0; count < characters.size(); count++) {
            charactersArray[count] = characters.get(count);
        }

        return charactersArray;
    }
}
