package com.codecool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FilePartReader {

    public FilePartReader() {
        String filePath = "invalid";
        int fromLine = -1;
        int toLine = -1;
    }

    public void setup(String filePath, int fromLine, int toLine) {

        if ((toLine < fromLine) || fromLine < 1) {
            throw new IllegalArgumentException("Wrong start / stop value!");
        }
    }

    private String read() throws IOException {
        File file = new File("/home/kali/codecool/JAVA/filepartreader-testing-with-junit-KALIWWA/src/com/codecool/test.txt");
        StringBuilder content = new StringBuilder();
        List<String> allLinesList = Files.readAllLines(file.toPath());
        for (int i = 0; i < allLinesList.size(); i++) {
            if (i < allLinesList.size() - 1) {
                content.append(allLinesList.get(i));
                content.append(",");
            } else {
                content.append(allLinesList.get(i));
            }
        }
        System.out.println(content + " <- read()");
        return String.valueOf(content);

    }

    public String readLines(int fromLine, int toLine) {
        StringBuilder requestedLines = new StringBuilder();
        try {
            String fileString = read();
            String[] allLinesList = fileString.split(",");

            for (int i = 0; i <= toLine; i++) {
                if (i >= fromLine) {
                    String singleLine = allLinesList[i - 1];
                    requestedLines.append(singleLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(requestedLines + " <- readLines(int fromLine, int toLine)");
        return String.valueOf(requestedLines);
    }

    public String readLines() {
        StringBuilder requestedLines = new StringBuilder();
        try {
            String fileString = read();
            String[] allLinesList = fileString.split(",");

            for (String singleLine : allLinesList) {
                requestedLines.append(singleLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(requestedLines + " <- readLines()");
        return String.valueOf(requestedLines);
    }

}
