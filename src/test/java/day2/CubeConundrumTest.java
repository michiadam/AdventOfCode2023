package day2;

import org.junit.jupiter.api.Test;
import util.InputReader;

import static org.junit.jupiter.api.Assertions.*;

class CubeConundrumTest {


    private static final String EXAMPLE_INPUT_FILE_PATH = "day2/ExampleInput";
    private static final String EXAMPLE_INPUT_FILE_PATH_2 = "day2/ExampleInput2";

    private static final CubeConundrum cubeConundrum = new CubeConundrum();

    @Test
    void cubeConundrom_shouldHandleExampleInput1() {
        String[] example = InputReader.readInput(EXAMPLE_INPUT_FILE_PATH);
        String input = example[0];
        String expectedOutput = example[1];
        int actualOutput = cubeConundrum.cubeConundrom(input);

        assertEquals(Integer.parseInt(expectedOutput), actualOutput);
        System.out.println("CubeConundromExample1: " + actualOutput);
    }

    @Test
    void cubeConundrom2_shouldHandleExampleInput2() {
        String[] example = InputReader.readInput(EXAMPLE_INPUT_FILE_PATH_2);
        String input = example[0];
        String expectedOutput = example[1];
        int actualOutput = cubeConundrum.cubeConundrom2(input);

        assertEquals(Integer.parseInt(expectedOutput), actualOutput);
        System.out.println("CubeConundromExample2: " + actualOutput);
    }
}