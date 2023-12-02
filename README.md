# AdventOfCode2023
This is my collection of solutions for the [Advent of Code 2023](https://adventofcode.com/2023) challenge.
## --- [Day 1: Trebuchet?!](https://adventofcode.com/2023/day/1) ---
A good introduction to the challenge. I was able to solve it in a few minutes.
## --- [Day 2: Cube Conundrum](https://adventofcode.com/2023/day/2) ---
This one was a bit harder. Mainly consisted of correctly extracting and parsing the lines to extract "GameID" and number of colors used.
The first part was easy, just validating and summing up the GameID's.
In part two I build a map over an util enum to keep track of the minimum required colors for each game. Then I just had to multiply the values in the map.
