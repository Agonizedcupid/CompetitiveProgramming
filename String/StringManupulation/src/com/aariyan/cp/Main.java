package com.aariyan.cp;

public class Main {

    public static void main(String[] args) {

        String[] input = {"geeksforgeeks", "geeks", "geek", "geezer"};

        System.out.println(longestCommonPrefix(input));
    }

    private static String longestCommonPrefix (String[] input) {
        if (input.length == 0) return "";
        String prefix = input[0];

        for (int index = 1; index < input.length; index ++) {
            while (input[index].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }

        return prefix;
    }
}
