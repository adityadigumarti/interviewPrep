package com.google.interview.regEx;

public class MyPatternMatching {

    public boolean match(String string, String pattern) {
        return match(string, pattern, pattern);
    }

    public boolean match(String string, String pattern, String subPattern) {
        // Found Pattern
        if (subPattern.length() == 0) {
            return true;
        }

        // Pattern not found.
        if (string.length() == 0) {
            return false;
        }

        if (subPattern.charAt(0) == string.charAt(0)) {
            if (subPattern.length() > 1) {
                if (subPattern.charAt(1) == '*') {
                    return matchPatternForStar(string.substring(1), pattern, subPattern.substring(1),
                            subPattern.charAt(0));
                } else if (subPattern.charAt(1) == '+') {
                    return matchPatternForPlus(string.substring(1), pattern, subPattern.substring(1),
                            subPattern.charAt(0));
                }
            }

            return match(string.substring(1), pattern, subPattern.substring(1));
        }

        return match(string.substring(1), pattern, pattern);
    }

    public boolean matchPatternForStar(String string, String pattern, String subPattern, char previousChar) {
        if (string.length() == 0) {
            return true;
        }

        if (string.charAt(0) == previousChar) {
            return matchPatternForStar(string.substring(1), pattern, subPattern, previousChar);
        }

        return match(string, pattern, subPattern.substring(1));

    }

    public boolean matchPatternForPlus(String string, String pattern, String subPattern, char previousChar) {
        if (string.length() == 0) {
            return false;
        }

        if (string.charAt(0) == previousChar) {
            return matchPatternForStar(string.substring(1), pattern, subPattern, previousChar);
        }

        return false;

    }

    public static void main(String args[]) {
        MyPatternMatching patternMatching = new MyPatternMatching();

        System.out.println(patternMatching.match("abc", "ab"));
        System.out.println(patternMatching.match("ab", "ab"));
        System.out.println(patternMatching.match("aaaaabac", "ab"));
        System.out.println(patternMatching.match("aaaaabc", "bc"));
        System.out.println(patternMatching.match("aaaaabac", "bc"));

        System.out.println(patternMatching.match("abbbbbbbbbac", "a*b"));
        System.out.println(patternMatching.match("aaaaaaaaaaaaabac", "a*b"));
        System.out.println(patternMatching.match("xxxxxxxaaaaaabac", "a*b"));
        System.out.println(patternMatching.match("acbac", "a*b"));
        System.out.println(patternMatching.match("acbac", "a*c"));
        System.out.println(patternMatching.match("acbac", "a+b"));
        System.out.println(patternMatching.match("aabac", "a+b"));
        System.out.println(patternMatching.match("abac", "a+b"));
        System.out.println(patternMatching.match("abac", "a*b"));
        System.out.println(patternMatching.match("abac", "a+b"));

    }
}
