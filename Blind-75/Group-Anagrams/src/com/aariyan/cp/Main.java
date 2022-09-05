package com.aariyan.cp;

import java.util.*;

public class Main {
    public static HashMap<String, Integer> table = new HashMap<>();

    public static void main(String[] args) {
        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};

        TreeMap<String, Integer> map = new TreeMap<>();
        String[] array = {"b","b","a","c"};
        for (int i=0; i<anagrams.length; i++) {
            map.put(anagrams[i], i);
        }

        for (String string: map.keySet()) {
            System.out.println(string);
        }


        //System.out.println(groupAnagrams(anagrams));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listOfGroups = new ArrayList<>();

        Hashtable<String, Integer> hash = new Hashtable<>();
        for (int i=0; i<strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            hash.put(strs[i], i);
        }

        List<String> firstList = new ArrayList<>();
        for (int i=0; i< strs.length; i++) {
            char[] array = strs[i].toCharArray();
            Arrays.sort(array);
            if (hash.contains(array)) {
                for (int j = 0; j<hash.size(); j++) {
                    firstList.add(strs[hash.get(array)]);
                }
            }
        }
        listOfGroups.add(firstList);

//        for (int i = 0; i < strs.length; i++) {
//            putOnHasTableWithSorted(strs[i].toCharArray(), i);
//        }
//
//        List<String> secondaryList = new ArrayList<>();
////        for (int i = 0; i < table.size(); i++) {
////            if (table.containsValue(strs[i])) {
////                System.out.println("Called: " + strs[i]);
////                secondaryList.add(strs[table.get(strs[i])]);
////            }
////            listOfGroups.add(secondaryList);
////        }
//
//        String[] anagrams = {"eat", "tea", "tan", "ate", "nat", "bat"};
//        for (int i = 0; i < table.size(); i++) {
//            System.out.println(table.get(anagrams[i]));
//        }

        return listOfGroups;
    }

    public static void putOnHasTableWithSorted(char[] array, int index) {
        String val = String.valueOf(array);
        Arrays.sort(array);
        table.put(val, index);
    }
}
