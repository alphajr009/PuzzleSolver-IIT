package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class PuzzleSolver {

    private char[][] map;
    private int startRow;
    private int startCol;
    private int finishRow;
    private int finishCol;
    private final int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private List<String> steps;

    public PuzzleSolver(char[][] map) {
        this.map = map;
        validateMap();
        findStartAndFinish();
    }

    private void validateMap() {
        int expectedLength = map[0].length;

        for (int i = 1; i < map.length; i++) {
            if (map[i].length != expectedLength) {
                throw new IllegalArgumentException("Invalid map: rows have different lengths");
            }
        }
    }

    private void findStartAndFinish() {
        boolean foundStart = false;
        boolean foundFinish = false;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 'S') {
                    startRow = i;
                    startCol = j;
                    foundStart = true;
                } else if (map[i][j] == 'F') {
                    finishRow = i;
                    finishCol = j;
                    foundFinish = true;
                }
            }
        }

        if (!foundStart || !foundFinish) {
            throw new IllegalArgumentException("Invalid map: Start or Finish not found");
        }
    }

    public List<String> solve() {
        steps = new ArrayList<>();
        PriorityQueue<Node> openSet = new PriorityQueue<>();
        openSet.add(new Node(startRow, startCol));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.getX() == finishRow && current.getY() == finishCol) {
                reconstructPath(current);
                break;
            }

            for (int[] dir : directions) {
                int newX = current.getX() + dir[0];
                int newY = current.getY() + dir[1];

                if (isValidMove(newX, newY)) {
                    Node neighbor = new Node(newX, newY);
                    int tentativeG = current.getG() + 1;

                    if (tentativeG < neighbor.getG() || !openSet.contains(neighbor)) {
                        neighbor.setParent(current);
                        neighbor.setG(tentativeG);
                        neighbor.setH(calculateHeuristic(newX, newY));
                        openSet.add(neighbor);
                    }
                }
            }
        }

        return steps;
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < map.length && y >= 0 && y < map[0].length && map[x][y] != '0';
    }

    private int calculateHeuristic(int x, int y) {
        return Math.abs(x - finishRow) + Math.abs(y - finishCol);
    }

    private void reconstructPath(Node current) {
        while (current.getParent() != null) {
            steps.add(0, generateStep(current, current.getParent()));
            current = current.getParent();
        }
        steps.add(0, "Start at (" + (startCol + 1) + "," + (startRow + 1) + ")");
        steps.add("Done!");
    }

    private String generateStep(Node current, Node parent) {
        int deltaX = parent.getX() - current.getX();
        int deltaY = parent.getY() - current.getY();

        if (deltaX == -1 && deltaY == 0) {
            return "Move down to (" + (current.getY() + 1) + "," + (current.getX() + 1) + ")";
        } else if (deltaX == 1 && deltaY == 0) {
            return "Move up to (" + (current.getY() + 1) + "," + (current.getX() + 1) + ")";
        } else if (deltaX == 0 && deltaY == -1) {
            return "Move right to (" + (current.getY() + 1) + "," + (current.getX() + 1) + ")";
        } else if (deltaX == 0 && deltaY == 1) {
            return "Move left to (" + (current.getY() + 1) + "," + (current.getX() + 1) + ")";
        }

        return "Invalid move";
    }
}
