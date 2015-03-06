package com.google.interview.regEx;

public class PatternMatching {

    public static boolean pattern(String input, String regx) {
        if (input.length() == 0 && regx.length() == 0) {
            return true;
        }

        if (input.length() >= 0 && regx.length() == 0) {
            return false;
        }

        if (input.length() == 0 && regx.length() >= 0) {
            return true;
        }

        String curStr = input.substring(0, 1);
        String curReg = regx.substring(0, 1);
        String nextReg = regx.substring(1, 2);

        if (curStr == curReg) {
            return pattern(input.substring(1, input.length() - 1), regx.substring(1, regx.length() - 1));
        }

        if (curReg == "*") {
            while (true) {
                if (curStr == nextReg && input.length() >= 0) {
                    input = input.substring(1, input.length() - 1);

                } else {
                    if (regx.length() >= 2)
                        regx = regx.substring(1, 2);
                    else
                        regx = "";

                    break;
                }
            }

            return pattern(input, regx);

        }

        if (curReg == "+") {
            if (curStr == nextReg) {
                while (true) {
                    if (curStr == nextReg && input.length() >= 0) {
                        input = input.substring(1, input.length());
                    } else {

                        if (regx.length() >= 2)
                            regx = regx.substring(1, 2);
                        else
                            regx = "";
                        break;
                    }
                }

                return pattern(input, regx);
            } else
                return false;
        }

        return false;

    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(PatternMatching.pattern("aaaab", "a*b"));

    }

}
