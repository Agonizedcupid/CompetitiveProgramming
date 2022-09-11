package com.aariyan.cp;

import java.util.Stack;

// Time O(n)
//Space O(n)

public class Main {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;
        if (s.equals("")) return false;

        Stack<Character> contain = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if ((!contain.isEmpty()) && (
                    (contain.peek().equals('(') && s.charAt(i) == ')') ||
                            (contain.peek().equals('{') && s.charAt(i) == '}') ||
                            (contain.peek().equals('[') && s.charAt(i) == ']'))
            ) {
                contain.pop();
            } else {
                contain.push(s.charAt(i));
            }
        }

        if (contain.isEmpty()) {
            return true;
        }
        return false;
    }
}
