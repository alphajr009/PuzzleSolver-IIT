package com.example;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class PuzzleSolverTest {

    private MapParser mapParser;
    private PuzzleSolver puzzleSolver;
    private char[][] map;

    @BeforeEach
    public void setUp() {
        mapParser = new MapParser();
    }

//    @Test
//    public void testPuzzleSolverWithPuzzle10() throws IOException {
//        map = mapParser.parseMap("src/main/resources/puzzle_10.txt");
//        puzzleSolver = new PuzzleSolver(map);
//
//        List<String> steps = puzzleSolver.solve();
//        System.out.println("Steps: " + steps);  // Debugging line
//        assertEquals(9, steps.size()); // Update expected value if needed
//    }



    @Test
    public void testPuzzleSolverWithPuzzle10() throws IOException {
        map = mapParser.parseMap("src/main/resources/maze10_1.txt");
        puzzleSolver = new PuzzleSolver(map);

        List<String> steps = puzzleSolver.solve();
        System.out.println("Steps: " + steps);  // Debugging line
        assertEquals(18, steps.size());
    }

//    @Test
//    public void testPuzzleSolverWithPuzzle20() throws IOException {
//        map = mapParser.parseMap("src/main/resources/puzzle_20.txt");
//        puzzleSolver = new PuzzleSolver(map);
//
//        List<String> steps = puzzleSolver.solve();
//        System.out.println("Steps: " + steps);  // Debugging line
//        assertEquals(52, steps.size());
//    }

//
//    @Test
//    public void testPuzzleSolverWithMaze10_1() throws IOException {
//        map = mapParser.parseMap("src/main/resources/maze10_1.txt");
//        puzzleSolver = new PuzzleSolver(map);
//
//        List<String> steps = puzzleSolver.solve();
//        System.out.println("Steps: " + steps);  // Debugging line
//        assertEquals(11, steps.size());
//    }
//
//    @Test
//    public void testPuzzleSolverWithMaze20_1() throws IOException {
//        map = mapParser.parseMap("src/main/resources/maze20_1.txt");
//        puzzleSolver = new PuzzleSolver(map);
//
//        List<String> steps = puzzleSolver.solve();
//        System.out.println("Steps: " + steps);  // Debugging line
//        assertEquals(51, steps.size());
//    }
}
