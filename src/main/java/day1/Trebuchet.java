package day1;

import util.InputReader;



/**
 * Created by Michael
 *
 * @link <a href="https://adventofcode.com/2023/day/1">Day 1</a>
 */
public class Trebuchet {

    private static final String[] DIGITS = new String[]{
            "zero", "one", "two", "three", "four",
            "five", "six", "seven", "eight", "nine"
    };


    /**
     * Your calculation isn't quite right. It looks like some of the digits are actually spelled out with letters:
     * one, two, three, four, five, six, seven, eight, and nine also count as valid "digits".
     * @param input A multi-line string containing the text for the elves
     * @return The sum of the first and last digit of each line (where the digits can be spelled out)
     */
    public int trebuchet2(String input){
        String[] lines = input.split(System.lineSeparator());

        int sum = 0;
        for (String line : lines) {
            Integer firstDigit = null;
            Integer lastDigit = null;
            StringBuilder spelledOut = new StringBuilder();

            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    if (firstDigit == null) {
                        firstDigit = digit;
                    }
                    lastDigit = digit;
                    spelledOut.setLength(0);
                    continue;
                }
                spelledOut.append(c);
                for (int i = 0; i < DIGITS.length; i++) {
                    String digit = DIGITS[i];
                    //note: in the test data I noticed "eightwo" so we needed to check with endsWith instead of equals(and a clear SB)
                    if (spelledOut.toString().endsWith(digit)) {
                        if (firstDigit == null) {
                            firstDigit = i;
                        }
                        lastDigit = i;
                    }
                }

            }

            if (firstDigit != null) {
                sum += firstDigit * 10 + lastDigit;
            }
        }
        return sum;
    }

    /**
     * The newly-improved calibration document consists of lines of text;
     * each line originally contained a specific calibration value that the Elves now need to recover.
     * On each line, the calibration value can be found by combining the first digit and the last digit (in that order)
     * to form a single two-digit number.
     * @param input A multi-line string containing the text for the elves
     * @return The sum of the first and last digit of each line
     */

    public int trebuchet(String input) {
        String[] lines = input.split(System.lineSeparator());

        int sum = 0;
        for (String line : lines) {
            Integer firstDigit = null;
            Integer lastDigit = null;
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    int digit = Character.getNumericValue(c);
                    if (firstDigit == null) {
                        firstDigit = digit;
                    }
                    lastDigit = digit;

                }
            }
            if(firstDigit == null) {
                continue;
            }
            sum += firstDigit * 10 + lastDigit;

        }
        return sum;
    }

    public static void main(String[] args) {

        Trebuchet trebuchet = new Trebuchet();
        System.out.println(trebuchet.trebuchet(InputReader.readInput("day1/PuzzleInput")[0]));
        System.out.println(trebuchet.trebuchet2(InputReader.readInput("day1/PuzzleInput2")[0]));
    }


}
