package adventofcode.year2017.day4;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PassphraseCheckerTest {
    @Test
    public void should_validate_passphrase_with_no_duplicate_words() {
        assertThat(PassphraseChecker.hasDuplicateWord("aa bb cc dd ee")).isFalse();
        assertThat(PassphraseChecker.isValid("aa bb cc dd ee")).isTrue();
    }

    @Test
    public void should_not_validate_passphrase_with_duplicate_words() {
        assertThat(PassphraseChecker.hasDuplicateWord("aa bb cc dd aa")).isTrue();
        assertThat(PassphraseChecker.isValid("aa bb cc dd aa")).isFalse();
    }

    @Test
    public void should_validate_passphrase_with_no_duplicate_words_but_sub_strings() {
        assertThat(PassphraseChecker.hasDuplicateWord("aa bb cc dd aaa")).isFalse();
        assertThat(PassphraseChecker.isValid("aa bb cc dd aaa")).isTrue();
    }

    @Test
    public void should_not_validate_passphrase_with_anagrams() {
        assertThat(PassphraseChecker.hasAnagram("abcde xyz ecdab")).isTrue();
        assertThat(PassphraseChecker.hasDuplicateWord("abcde xyz ecdab")).isFalse();
        assertThat(PassphraseChecker.isValid("abcde xyz ecdab")).isFalse();

        assertThat(PassphraseChecker.hasAnagram("oiii ioii iioi iiio")).isTrue();
        assertThat(PassphraseChecker.hasDuplicateWord("oiii ioii iioi iiio")).isFalse();
        assertThat(PassphraseChecker.isValid("oiii ioii iioi iiio")).isFalse();


    }

    @Test
    public void should_validate_passphrase_with_no_anagram_and_no_duplicate_word() {
        assertThat(PassphraseChecker.hasAnagram("iiii oiii ooii oooi oooo")).isFalse();
        assertThat(PassphraseChecker.hasDuplicateWord("iiii oiii ooii oooi oooo")).isFalse();
        assertThat(PassphraseChecker.isValid("iiii oiii ooii oooi oooo")).isTrue();
    }

    @Test
    public void kata_result() {
        var textFileReader = new TextFileReader("src/test/resources/2017/day4/passphrases.txt");
        var validPassphrases = textFileReader.lines().filter(PassphraseChecker::isValid);
        assertThat(validPassphrases).hasSize(119);
    }
}
