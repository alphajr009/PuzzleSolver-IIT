package com.example;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            // Initialize MapParser
            MapParser mapParser = new MapParser();

            // Read map from file
            char[][] map = mapParser.parseMap("src/main/resources/puzzle_10.txt");

            // Initialize PuzzleSolver
            PuzzleSolver puzzleSolver = new PuzzleSolver(map);

            // Solve the puzzle
            List<String> steps = puzzleSolver.solve();

            // Print the solution steps
            for (String step : steps) {
                System.out.println(step);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
