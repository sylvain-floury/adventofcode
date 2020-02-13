package adventofcode.year2017.day2;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ChecksumCalculator {
    public static int checksum(String spreadsheet) {
        return Stream.of(spreadsheet.split("\\n"))
                .mapToInt(ChecksumCalculator::difference)
                .reduce(0, (a, b) -> a + b);
                //.sum();

    }

    public static int difference(String row) {
        return max(row) - min(row);
    }

    public static int min(String row) {
        return splitIntoStream(row)
                .min()
                .orElseThrow(() -> new IllegalArgumentException("Invalid row"));
    }

    public static int max(String row) {
        return splitIntoStream(row)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("Invalid row"));
    }

    private static IntStream splitIntoStream(String row) {
        return Stream.of(row.split("\\s+"))
                .mapToInt(Integer::parseInt);
    }
}
