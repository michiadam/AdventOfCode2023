package day1;

import org.junit.jupiter.api.Test;
import util.InputReader;

import static org.junit.jupiter.api.Assertions.*;

class TrebuchetTest {


    private static final String EXAMPLE_INPUT_FILE_PATH = "day1/ExampleInput";
    private static final String EXAMPLE_INPUT_FILE_PATH_2 = "day1/ExampleInput2";

    private static final Trebuchet trebuchet = new Trebuchet();

    @Test
    void trebuchet_shouldHandleExampleInput1() {
        String[] example = InputReader.readInput(EXAMPLE_INPUT_FILE_PATH);
        String input = example[0];
        String expectedOutput = example[1];
        int actualOutput = trebuchet.trebuchet(input);

        assertEquals(Integer.parseInt(expectedOutput), actualOutput);
        System.out.println("TrebuchetExample1: " + actualOutput);
    }
    @Test
    void trebuchet2_shouldHandleExampleInput2() {
        String[] example = InputReader.readInput(EXAMPLE_INPUT_FILE_PATH_2);
        String input = example[0];
        String expectedOutput = example[1];
        int actualOutput = trebuchet.trebuchet2(input);

        assertEquals(Integer.parseInt(expectedOutput), actualOutput);
        System.out.println("TrebuchetExample2: " + actualOutput);
    }
}