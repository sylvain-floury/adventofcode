package adventofcode.year2017.day4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextFileReader {
    Stream<String> lines;

    public TextFileReader(String filepath) {
        try {
            var path = Paths.get(filepath);
            lines = Files.lines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Stream<String> lines() {
        return lines;
    }
}
