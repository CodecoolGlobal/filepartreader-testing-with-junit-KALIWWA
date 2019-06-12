package com.codecool;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {


    public void setup(String filePath, int fromLine, int toLine) {

        if ((toLine < fromLine) || fromLine < 1) {
            throw new IllegalArgumentException("Wrong start / stop value!");
        }
    }

    public String read() throws IOException {
        File file = new File("/home/kali/codecool/JAVA/filepartreader-testing-with-junit-KALIWWA/src/com/codecool/test.txt");
        StringBuilder content = new StringBuilder();
        List<String> allLinesList = Files.readAllLines(file.toPath());
        for (int i = 0; i < allLinesList.size() - 1; i++) {
            content.append(allLinesList.get(i));
            content.append(",");
        }
        return String.valueOf(content);

    }

    public String readLines(int fromLine, int toLine) {
        StringBuilder requestedLines = new StringBuilder();
        try {
            String fileString = read();
            String[] allLinesList = fileString.split(",");

            for (int i = 1; i <= toLine; i++) {
                if (i >= fromLine) {
                    String singleLine = allLinesList[i];
                    requestedLines.append(singleLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(requestedLines);
    }

}
