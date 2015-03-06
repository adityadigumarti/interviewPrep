package com.google.interviews.misc;

public class ExceptonFinally {

    /**
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new ExceptonFinally().tryThis();
    }

    public void tryThis() throws Exception {
        try {
            throw new Exception("Exception 1");
        } finally {
            throw new Exception("Exception 2");
        }
    }

}
