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


//    public List getWordsContainingSubstring(String subString) {
//        List<String> allLinesArray = createArrayList();
//
//
//    }
}
