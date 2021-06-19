package com.efimchick.ifmo.collections.countwords;


import java.util.*;


public class Words {
    public String countWords(List<String> lines) {
        Map<String, Integer> wordMap = new HashMap<>();
        for (String line : lines) {
            String[] words = line.toLowerCase().split("(?U)[\\pP\\s\\d+]");
            for (int i = 0; i < words.length; i++) {
                if (words[i].length() >= 4) {
                    if (wordMap.get(words[i]) == null) {
                        wordMap.put(words[i], 1);
                    } else {
                        wordMap.put(words[i], wordMap.get(words[i]) + 1);
                    }
                }
            }
        }
        List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordMap.entrySet());
        Collections.sort(sortedWords, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue().equals( o1.getValue())) {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    int i = 0;
                    while (i < s1.length() && i < s2.length()) {

                        if (s1.charAt(i) > s2.charAt(i)) {
                            return 1;

                        } else if (s1.charAt(i) < s2.charAt(i)) {
                            return -1;

                        } else if (i == s1.length() - 1 ) {

                            return -1;
                        } else if (i == s2.length() - 1 ) {

                            return 1;

                        }else {
                            i++;
                        }

                    }
                }
                return o2.getValue() - o1.getValue();

            }
        });
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : sortedWords) {
            if (entry.getValue() > 10 && result.length() == 0) {
                result.append(entry.getKey() + " - " + entry.getValue());
            } else if (entry.getValue() >= 10) {
                result.append("\n" + entry.getKey() + " - " + entry.getValue());
            }
        }

        return result.toString();

    }
}






