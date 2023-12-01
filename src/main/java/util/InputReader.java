package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputReader {


    public static String[] readInput(String fileName) {
        // read resource/fileName.inp
        String[] input = new String[2];

        Path filePath = Paths.get("src/main/resources", fileName + ".inp");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath.toFile()))) {
            String line;
            StringBuilder inputBuilder = new StringBuilder();
            StringBuilder outputBuilder = new StringBuilder();
            boolean readingInput = false;
            boolean readingOutput = false;

            // Read line by line
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("#")) {
                    if (line.contains("input")) {
                        readingInput = true;
                        readingOutput = false;
                    } else if (line.contains("output")) {
                        readingInput = false;
                        readingOutput = true;
                    }
                } else {
                    if (readingInput) {
                        inputBuilder.append(line).append(System.lineSeparator());
                    } else if (readingOutput) {
                        outputBuilder.append(line).append(System.lineSeparator());
                    }
                }
            }

            input[0] = inputBuilder.toString().trim();
            input[1] = outputBuilder.toString().trim();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return input;
    }



}
