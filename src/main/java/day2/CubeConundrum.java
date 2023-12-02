package day2;

import util.InputReader;

import java.util.EnumMap;
import java.util.Map;
/**
 * Created by Michael
 *
 * @link <a href="https://adventofcode.com/2023/day/2">Day 2</a>
 */
public class CubeConundrum {

    /**
     * Utility enum to represent the colors of the cubes
     */
    public enum COLORS {
        red,green,blue
    }

    /**
     * The Elf says they've stopped producing snow because they aren't getting any water!
     * He isn't sure why the water stopped;
     * however, he can show you how to get to the water source to check it out for yourself. It's just up ahead!
     * @param input A multi-line string containing the text for the elves
     * @return The power of the min required cube colors
     */

    public int cubeConundrom2(String input){
        String[] lines = input.split(System.lineSeparator());
        int sum = 0;
        for (String game : lines) {
            //Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
            game = game.substring(game.indexOf(":") + 1);

            String[] games = game.split(";");

            Map<COLORS, Integer> colorMinCount = new EnumMap<>(COLORS.class);
            for (String subGame : games) {
                subGame = subGame.trim();
                // 3 blue, 4 red

                String[] colors = subGame.split(",");

                for (String color : colors) {
                    color = color.trim();
                    // 3 blue
                    String[] colorSplit = color.split(" ");
                    int count = Integer.parseInt(colorSplit[0]);
                    COLORS colorName = COLORS.valueOf(colorSplit[1]);
                    if(colorMinCount.containsKey(colorName)){
                        colorMinCount.put(colorName, Math.max(colorMinCount.get(colorName), count));
                    }else{
                        colorMinCount.put(colorName, count);
                    }
                }
            }

            int power = 1;
            for (Map.Entry<COLORS, Integer> colorsIntegerEntry : colorMinCount.entrySet()) {
                power *= colorsIntegerEntry.getValue();
            }
            sum += power;

        }
        return sum;
    }

    /**
     * You're launched high into the atmosphere!
     * The apex of your trajectory just barely reaches the surface of a large island floating in the sky.
     * You gently land in a fluffy pile of leaves. It's quite cold, but you don't see much snow.
     * An Elf runs over to greet you.
     * The Elf would first like to know which games would have been possible
     * if the bag contained only 12 red cubes, 13 green cubes, and 14 blue cubes?
     *
     * @param input A multi-line string containing the text for the elves
     * @return The sum of the game numbers that are valid
     */
    public int cubeConundrom(String input){
        Map<COLORS, Integer> maxColors = Map.of(COLORS.red, 12, COLORS.green, 13, COLORS.blue, 14);

        String[] lines = input.split(System.lineSeparator());
        int sum = 0;
        for (String game : lines) {
            int gameNumber = Integer.parseInt(game.substring(5, game.indexOf(":")));
            game = game.substring(game.indexOf(":") + 1);

            String[] games = game.split(";");

            boolean valid = true;
            for (String subGame : games) {
                subGame = subGame.trim();

                String[] colors = subGame.split(",");
                Map<COLORS, Integer> colorCount = new EnumMap<>(COLORS.class);

                for (String color : colors) {
                    color = color.trim();
                    String[] colorSplit = color.split(" ");
                    int count = Integer.parseInt(colorSplit[0]);
                    COLORS colorName = COLORS.valueOf(colorSplit[1]);
                    colorCount.put(colorName, count);
                }

                for (COLORS color : COLORS.values()) {
                    if (colorCount.getOrDefault(color, 0) > maxColors.get(color)) {
                        valid = false;
                        break;
                    }
                }


            }

            if(valid){
                sum += gameNumber;
            }

        }
        return sum;
    }


    public static void main(String[] args) {

        CubeConundrum cubeConundrum = new CubeConundrum();
        System.out.println(cubeConundrum.cubeConundrom(InputReader.readInput("day2/PuzzleInput")[0]));
        System.out.println(cubeConundrum.cubeConundrom2(InputReader.readInput("day2/PuzzleInput2")[0]));

    }

}
