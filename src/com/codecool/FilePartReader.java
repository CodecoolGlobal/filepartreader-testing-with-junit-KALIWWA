package com.codecool;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;

public class FilePartReader {

    private File file = new File("/home/kali/codecool/JAVA/filepartreader-testing-with-junit-KALIWWA/src/com/codecool/test.txt");

    public void setup(String filePath, int fromLine, int toLine) {

        if ((toLine < fromLine) || fromLine < 1) {
            throw new IllegalArgumentException("Wrong start / stop value!");
        }
    }

    public String read() throws IOException {

        String content;
        if (!Desktop.isDesktopSupported()) {
            System.out.println("Desktop is not supported!");
        }

        Desktop desktop = Desktop.getDesktop();
        if (file.exists()) {
            desktop.open(file);
            content = Arrays.toString(Files.readAllBytes(file.toPath()));
            return content;
        } else {
            throw new IllegalArgumentException("No such a file!");
        }
    }

    public String readLines(int fromLine, int toLine) {
        StringBuilder requestedLines = new StringBuilder();
        try {
            List<String> allLinesList = Files.readAllLines(file.toPath());
            for (int i = 1; i <= toLine; i++) {
                if (i >= fromLine) {
                    String singleLine = allLinesList.get(i);
                    requestedLines.append(singleLine);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return String.valueOf(requestedLines);
    }


}
