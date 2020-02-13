package adventofcode.year2017.day4;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PassphraseChecker {
    public static boolean hasDuplicateWord(String passphrase) {
        return toStream(passphrase).count() != toStream(passphrase).distinct().count();
    }

    public static boolean hasAnagram(String passphrase) {
        var anagrams = countAnagrams(passphrase);

        return anagrams.values().stream().anyMatch(count -> count > 0);
    }

    public static Map<String, Integer> countAnagrams(String passphrase) {
        var anagramsCount = new HashMap<String, Integer>();
        toStream(passphrase)
            .forEach(string -> {
                var sortedString = string.chars().mapToObj(i->Character.toString((char)i)).sorted().collect(Collectors.joining());

                if (anagramsCount.containsKey(sortedString)) {
                    anagramsCount.put(sortedString, anagramsCount.get(sortedString) + 1);
                } else {
                    anagramsCount.put(sortedString, 0);
                }
            });
        return anagramsCount;
    }

    public static boolean isValid(String passphrase) {
        return !hasDuplicateWord(passphrase) && !hasAnagram(passphrase);
    }

    static Stream<String> toStream(String passphrase) {
        return Stream.of(passphrase.split(" "));
    }
}
