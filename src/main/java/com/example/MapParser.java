package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MapParser {

    public char[][] parseMap(String filePath) throws IOException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int cols = 0;

            while ((line = reader.readLine()) != null) {
                if (!line.isEmpty()) {
                    lines.add(line);
                    cols = Math.max(cols, line.length());
                }
            }

            char[][] map = new char[lines.size()][cols];

            for (int i = 0; i < lines.size(); i++) {
                line = lines.get(i);
                if (line.length() < cols) {
                    char[] paddedLine = new char[cols];
                    System.arraycopy(line.toCharArray(), 0, paddedLine, 0, line.length());
                    Arrays.fill(paddedLine, line.length(), cols, '0');
                    map[i] = paddedLine;
                } else {
                    map[i] = line.toCharArray();
                }
            }

            return map;
        }
    }
}
