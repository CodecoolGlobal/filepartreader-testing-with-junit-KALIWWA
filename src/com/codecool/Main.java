package com.codecool;

public class Main {
    public static void main(String[] args) {
        FilePartReader filePartReader = new FilePartReader();
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        String requestedLines = filePartReader.readLines();
        String requestedLinesFromTo = filePartReader.readLines(2,4);

//        System.out.println(requestedLines + " <- readLines()");
//        System.out.println(requestedLinesFromTo + " <- readLines(from to)");



        fileWordAnalyzer.getWordsOrderedAlphabetically();
        fileWordAnalyzer.getWordsContainingSubstring("da");
        fileWordAnalyzer.getStringsWhichPalindromes();
        }
}
