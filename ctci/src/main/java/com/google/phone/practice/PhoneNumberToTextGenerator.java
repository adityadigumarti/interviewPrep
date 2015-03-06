package com.google.phone.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberToTextGenerator {

    private static Map<Character, List<String>> phoneKeypadMap;

    static {
        initializePhoneKeypadMap();
    }

    public static void main(String args[]) {
        System.out.println(new PhoneNumberToTextGenerator().getAllTextCombinations("15626733141"));
    }

    public List<String> getAllTextCombinations(String phoneNumber) {
        if (phoneNumber.length() == 1) {
            return phoneKeypadMap.get(phoneNumber.charAt(0));
        }

        String remainingDigits = phoneNumber.substring(1);

        List<String> textPhoneNumbers = getAllTextCombinations(remainingDigits);

        return combine(phoneKeypadMap.get(phoneNumber.charAt(0)), textPhoneNumbers);

    }

    private List<String> combine(List<String> keyList, List<String> textPhoneNumbers) {
        List<String> combinedList = new ArrayList<String>();
        for (String digit : keyList) {
            for (String phoneNumber : textPhoneNumbers) {
                combinedList.add(digit + phoneNumber);
            }
        }

        return combinedList;
    }

    private static void initializePhoneKeypadMap() {
        phoneKeypadMap = new HashMap<Character, List<String>>();

        List<String> keyAlphabetList = new ArrayList();
        keyAlphabetList.add("1");
        phoneKeypadMap.put('1', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("A");
        keyAlphabetList.add("B");
        keyAlphabetList.add("C");
        phoneKeypadMap.put('2', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("D");
        keyAlphabetList.add("E");
        keyAlphabetList.add("F");
        phoneKeypadMap.put('3', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("G");
        keyAlphabetList.add("H");
        keyAlphabetList.add("I");
        phoneKeypadMap.put('4', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("J");
        keyAlphabetList.add("K");
        keyAlphabetList.add("L");
        phoneKeypadMap.put('5', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("M");
        keyAlphabetList.add("N");
        keyAlphabetList.add("O");
        phoneKeypadMap.put('6', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("P");
        keyAlphabetList.add("Q");
        keyAlphabetList.add("R");
        keyAlphabetList.add("S");
        phoneKeypadMap.put('7', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("T");
        keyAlphabetList.add("U");
        keyAlphabetList.add("V");
        phoneKeypadMap.put('8', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("W");
        keyAlphabetList.add("X");
        keyAlphabetList.add("Y");
        keyAlphabetList.add("Z");
        phoneKeypadMap.put('9', keyAlphabetList);

        keyAlphabetList = new ArrayList();
        keyAlphabetList.add("0");
        phoneKeypadMap.put('0', keyAlphabetList);

    }

}
