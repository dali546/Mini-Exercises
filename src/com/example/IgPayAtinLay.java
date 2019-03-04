package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IgPayAtinLay {

    public static void main(String[] args) throws IOException {
        String[] words = Files.readString(Paths.get("piglatin.txt")).split("\\s+");
        StringBuilder newSentence = new StringBuilder();
        String newWord;
        for (String word : words) {
            newWord = runRules(word);
            if (newWord.matches("^(?=.*[A-Z]).+")) newWord = changeUpperCase(newWord);
            newSentence.append(newWord).append(" ");
        }
        System.out.println(newSentence);
    }

    private static String changeUpperCase(String newWord) {
        return Character.toUpperCase(newWord.charAt(0)) + newWord.substring(1).toLowerCase();
    }

    private static String runRules(String word) {
        StringBuilder newWord = new StringBuilder();
        if (word.matches("^(?i)[0-9]+.*")) return newWord.append(word).toString();
        if (word.matches("^(?i)[^aeiou\\s]+.*")) conClusterRule(word, newWord);
        if (word.matches("^(?i)[aeiou].*")) vowelRule(word, newWord);
        return newWord.toString();
    }

    private static void conClusterRule(String word, StringBuilder newWord) {
        Pattern pattern = Pattern.compile("^((?i)[^aeiouy\\s]+)(\\w*)([.,]*)([']*)");
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            newWord.append(matcher.group(2))
                    .append(matcher.group(1))
                    .append("ay")
                    .append(matcher.group(4))
                    .append((!matcher.group(4).equals("")) ? "s" : "")
                    .append(matcher.group(3));
        } else {
            newWord.append(word);
            newWord.append("way");
        }
    }

    private static void vowelRule(String word, StringBuilder newWord) {
        Pattern pattern = Pattern.compile("^((?i)[aeiou]*(?:[^aeiou\\s]+))(\\w*)([.,]*)([']*)");
        Matcher matcher = pattern.matcher(word);
        if (matcher.find()) {
            newWord.append(matcher.group(2))
                    .append(matcher.group(1))
                    .append("ay")
                    .append(matcher.group(4))
                    .append(!matcher.group(4).equals("") ? "s" : "")
                    .append(matcher.group(3));
        } else {
            newWord.append(word);
            newWord.append("way");
        }
    }


}
