package com.codecool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileWordAnalyzer {
    public FileWordAnalyzer(FilePartReader filePartReader) {
    }

    private List<String> createArrayList() {
        FilePartReader filePartReader = new FilePartReader();
        String allLinesCommaSep = filePartReader.readLines();
        String[] allLinesList = allLinesCommaSep.split(",");
        return new ArrayList<>(Arrays.asList(allLinesList));
    }

    public List getWordsOrderedAlphabetically() {
        List<String> allLinesArray = createArrayList();

        allLinesArray.sort(String::compareToIgnoreCase);
        System.out.println(allLinesArray + " <- getWordsOrderedAlphabetically()");
        return allLinesArray;
    }


    public List getWordsContainingSubstring(String subString) {
        List<String> allLinesArray = createArrayList();
        List<String> allWordsByLineArray = new ArrayList<>();

        for (String singleLine : allLinesArray) {
            List<String> singleLineWordsArray = new ArrayList<>(Arrays.asList(singleLine.split(" ")));
            for (String singleWord : singleLineWordsArray) {
                if (singleWord.contains(subString)) {
                    allWordsByLineArray.add(singleWord);
                }
            }
        }
        return allWordsByLineArray;
    }

    public List getStringsWhichPalindromes() {
        List<String> allLinesArray = createArrayList();
        List<String> allWordsByLineArray = new ArrayList<>();

        for (String singleLine : allLinesArray) {
            List<String> singleLineWordsArray = new ArrayList<>(Arrays.asList(singleLine.split(" ")));
            for (String singleWord : singleLineWordsArray) {
                if (new StringBuilder(singleWord).reverse().toString().equals(singleWord)) {
                    allWordsByLineArray.add(singleWord);
                }
            }
        }
        System.out.println(allWordsByLineArray);
        return allWordsByLineArray;
    }
}