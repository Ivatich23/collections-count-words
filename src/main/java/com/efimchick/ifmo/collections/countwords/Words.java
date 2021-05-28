package com.efimchick.ifmo.collections.countwords;


import java.util.*;


public class Words {
    public String countWords(List<String> lines) {
        Map<String, Integer> values = new HashMap<>();
        for (String line : lines) {
            String[] s = line.split("[\\s.]");
            for (int i = 0; i < s.length; i++) {
                if (values.get(s[i]) == null) {
                    values.put(s[i], 1);
                } else {
                    values.put(s[i], values.get(s[i]) + 1);
                }
            }
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(values.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o2.getValue() == o1.getValue()) {
                    String s1 = o1.getKey();
                    String s2 = o2.getKey();
                    return s2.compareTo(s1);
                }else {
                    return o2.getValue() - o1.getValue();
                }
            }
        });
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : list) {
            if (entry.getValue() > 10 && entry.getKey().length() >= 4) {
                result.append(entry.getKey().toLowerCase() + " - " + entry.getValue() + "\n");
            }
        }
        String finalResult = result.toString();
        return finalResult;

    }
}






