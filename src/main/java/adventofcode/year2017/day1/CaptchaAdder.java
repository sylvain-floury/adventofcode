package adventofcode.year2017.day1;

import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class CaptchaAdder {

    private final IntStream digits;
    private final int first;

    public CaptchaAdder(String sequenceOfDigits) {
        digits = sequenceOfDigits.chars().map(Character::getNumericValue);
        first = Character.getNumericValue(sequenceOfDigits.charAt(0));
    }

    public int sum() {
        var result = new CaptchaResult();

        digits.forEach(digitConsumer(result));

        sumCircularList(result);

        return result.sum;
    }

    private IntConsumer digitConsumer(CaptchaResult result) {
        return a -> {
            sumAdjacentDigits(result, a, a);
            result.previous = a;
        };
    }

    private void sumAdjacentDigits(CaptchaResult result, int first, int previous) {
        if (first == result.previous) {
            result.sum += previous;
        }
    }

    private void sumCircularList(CaptchaResult result) {
        sumAdjacentDigits(result, first, result.previous);
    }

    private class CaptchaResult {
        int sum = 0;
        int previous = 0;
    }
}
