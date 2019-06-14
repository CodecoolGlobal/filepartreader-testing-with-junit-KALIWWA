package com.codecool;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FilePartReader {

    private File file = new File("/home/kali/codecool/JAVA/filepartreader-testing-with-junit-KALIWWA/src/com/codecool/test.txt");

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

    public String read() throws IOException {

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
        return String.valueOf(content);

    }

    public String readLines(int fromLine, int toLine) {
        StringBuilder requestedLines = new StringBuilder();
        try {
            String fileString = read();
            String[] allLinesList = fileString.split(",");

            for (int i = 1; i <= toLine; i++) {
                String singleLine = allLinesList[i - 1];
                if (i >= fromLine && i < toLine) {
                    requestedLines.append(singleLine);
                    requestedLines.append(",");
                } else if (i == toLine) {
                    requestedLines.append(singleLine);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(requestedLines);
    }

    public String readLines() {
        StringBuilder requestedLines = new StringBuilder();
        try {
            String fileString = read();
            String[] allLinesList = fileString.split(",");

            for (int i = 1; i <= allLinesList.length; i++) {
                String singleLine = allLinesList[i - 1];
                if (i == allLinesList.length) {
                    requestedLines.append(singleLine);
                } else {
                    requestedLines.append(singleLine);
                    requestedLines.append(",");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(requestedLines);
    }

}
