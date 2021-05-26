package com.efimchick.ifmo.collections.countwords;


import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Words {
    private int count;
    HashMap<String, String> values = new HashMap<>();

    public String checkWords(List<String> lines) {
        String lowerLines = lines.toArray().toString().toLowerCase();
        final String regex = "(?<!\\w)\\w{1,10}(?!\\w)";

        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(lowerLines);
        lines.clear();
        while (matcher.find()) {
            values.put(matcher.group(0), matcher.group(0));
            if (values.get(matcher.group(0)).equals(values.put(matcher.group(0), matcher.group(0)))) {
                count++;
            }
            lines.add(values.get(matcher.group(0) + " - " + count));
        }

        return lowerLines;
    }


    public String countWords(List<String> lines) {
        StringBuilder findWords = new StringBuilder();
        final String regex = "(?<!\\w)\\w{1,10}(?!\\w)";
        for (String line : lines) {
            if (regex.equals(line)) {
                values.put(line, line);
                findWords.append(values.get(line));
            }
            if (values.get(line) != null && values.get(line).equals(values.put(line, line))) {
                count++;
            }
            findWords.append(" - " + count + "\n");
            count = 0;
        }
        String finalResult = findWords.toString();
        return finalResult;
    }
}
