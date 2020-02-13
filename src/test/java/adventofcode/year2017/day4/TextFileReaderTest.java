package adventofcode.year2017.day4;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class TextFileReaderTest {
    @Test
    public void should_read_each_line() {
        var textFileReader = new TextFileReader("src/test/resources/2017/day4/passphrases.txt");
        var lines = textFileReader.lines().collect(Collectors.toList());
        assertThat(lines).hasSize(512);
        assertThat(lines.get(0)).isEqualTo("nyot babgr babgr kqtu kqtu kzshonp ylyk psqk");
    }
}
