package com.google.interviews.misc;

import java.util.ArrayList;
import java.util.List;

public class TestUpperCaseIterator {

    public static void main(String[] args) {
        List<Character> character = new ArrayList<Character>();
        UpperCaseIterator2 caseIterator1 = new UpperCaseIterator2(character);

        System.out.println(caseIterator1.next());

        while (caseIterator1.hasNext()) {
            System.out.println(caseIterator1.next());
        }

        System.out.println("***************************************");

        character.add('C');
        character.add('D');
        character.add('F');
        character.add('F');
        character.add('E');
        character.add('G');
        character.add('C');

        UpperCaseIterator2 caseIterator = new UpperCaseIterator2(character);

        System.out.println(caseIterator.next());
        caseIterator.remove();

        caseIterator = new UpperCaseIterator2(character);

        while (caseIterator.hasNext()) {
            System.out.println(caseIterator.next());
        }

    }

}
