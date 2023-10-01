package org.example.fileprocessor;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class FileProcessor {

    public void writeToFile(String filePath, int[][] array) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, false))) {
            for (int[] row : array) {
                String line = Arrays.toString(row);
                line = line.substring(1, line.length() - 1).replace(" ", "");
                writer
                        .append(line)
                        .append(System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToFile(String filePath, List<List<Integer>> arrayList) {
        int[][] array = new int[arrayList.size()][arrayList.get(0).size()];
        for (int i = 0; i < arrayList.size(); i++) {
            List<Integer> al = arrayList.get(i);
            for (int j = 0; j < al.size(); j++) {
                array[i][j] = al.get(j);
            }
        }
        writeToFile(filePath, array);
    }
}
